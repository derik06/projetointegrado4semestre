package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;

import dao.ConnectionFactory;
import dao.LedDAO;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import model.Led;
import service.LedService;

import java.util.Enumeration;


public class SerialTeste implements SerialPortEventListener {
    //    private static final dao.ConnectionFactory ConnectionFactory = ;
    SerialPort serialPort;
    /** The port we're normally going to use. */
    private static final String PORT_NAMES[] = {
            "/dev/tty.usbserial-A9007UX1", // Mac OS X
            "/dev/ttyACM0", // Raspberry Pi
            "/dev/ttyUSB0", // Linux
            "COM5", // Windows
    };
    /**
     * A BufferedReader which will be fed by a InputStreamReader
     * converting the bytes into characters
     * making the displayed results codepage independent
     */
    private BufferedReader input;
    /** The output stream to the port */
    private OutputStream output;
    /** Milliseconds to block while waiting for port open */
    private static final int TIME_OUT = 2000;
    /** Default bits per second for COM port. */
    private static final int DATA_RATE = 9600;

    public void initialize() {
        // the next line is for Raspberry Pi and
        // gets us into the while loop and was suggested here was suggested http://www.raspberrypi.org/phpBB3/viewtopic.php?f=81&t=32186

        CommPortIdentifier portId = null;
        Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();

        //First, Find an instance of serial port as set in PORT_NAMES.
        while (portEnum.hasMoreElements()) {
            CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
            System.out.println(currPortId.getName());
            for (String portName : PORT_NAMES) {
                if (currPortId.getName().equals(portName)) {
                    portId = currPortId;
                    break;
                }
            }
        }
        if (portId == null) {
            System.out.println("Could not find COM port.");
            return;
        }

        try {
            // open serial port, and use class name for the appName.
            serialPort = (SerialPort) portId.open(this.getClass().getName(),
                    TIME_OUT);

            // set port parameters
            serialPort.setSerialPortParams(DATA_RATE,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);

            // open the streams
            input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
            output = serialPort.getOutputStream();

            // add event listeners
            serialPort.addEventListener(this);
            serialPort.notifyOnDataAvailable(true);
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    /**
     * This should be called when you stop using the port.
     * This will prevent port locking on platforms like Linux.
     */
    public synchronized void close() {
        if (serialPort != null) {
            serialPort.removeEventListener();
            serialPort.close();
        }
    }

    /**
     * Handle an event on the serial port. Read the data and print it.
     */
    public synchronized void serialEvent(SerialPortEvent oEvent) {
        if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
            try {

                // lê a serial
                String inputLine=input.readLine();
                System.out.println(inputLine);


                Led led = new Led(inputLine);
                LedService service= new LedService();

                if (led.getStatus().equals("HIGH"))service.ligarLed(led);
                if (led.getStatus().equals("LOW")) service.desligarLed(led);

                //fim
//                String sqlInsert = "INSERT INTO TB_FATO_LED(CONSUMO) VALUES (?)";
//                // usando o try with resources do Java 7, que fecha o que abriu
//                String abc = "funcionou";
//                int potencia = 0;

//                try (Connection conn = ConnectionFactory.obterConexao();
//                     PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
//                    stm.setInt(1, potencia);
//                    stm.execute();
//                    System.out.println(abc);
//                    String sqlQuery = "SELECT LAST_INSERT_ID()";
//                    try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
//                         ResultSet rs = stm2.executeQuery();) {
//                        if (rs.next()) {
//                            System.out.print(rs.getInt(1));
//                        }
//                    } catch (SQLException e) {
//                        e.printStackTrace();
//                    }
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                } catch (IOException e) {
//                e.printStackTrace();
//            }
//                } finally {
//
//                    try {
//                        Connection conn = ConnectionFactory.obterConexao();
//                        try{
//                            conn.close();
//                        } catch (SQLException e){
//                            e.printStackTrace();
//                        }
//                    } catch (SQLException e){
//                        e.printStackTrace();
//                    }
//                }

            } catch (Exception e) {
                System.err.println(e.toString());
            }
        }
        // Ignore all the other eventTypes, but you should consider the other ones.
    }

    public static void main(String[] args) throws Exception {
        SerialTeste main = new SerialTeste();
        main.initialize();
        Thread t=new Thread() {
            public void run() {
                //the following line will keep this app alive for 1000 seconds,
                //waiting for events to occur and responding to them (printing incoming messages to console).
                try {Thread.sleep(1000000);} catch (InterruptedException ie) {}
            }
        };
        t.start();
        System.out.println("Started");
    }
}