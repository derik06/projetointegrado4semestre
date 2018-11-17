int       cont            = 0;
int     contBtn     = 0;
const int Led1            = 7;
const int Led2            = 6;
const int Led3            = 5;
const int btn             = 2;
const int sensor          = 4;
int       sensorLumiPin   = 0;  // select the input pin for the potentiometer
int       sensorLumiValue = 0;  // variable to store the value coming from the sensor
int       valorBtn = 0;
bool      valorSensor;
long previousMillis    = 0;
long previousMillisBtn = 0;
long redLedInterval = 2000;
long BtnInterval    = 6000;


void setup()
{
  //INPUT
  pinMode(btn, INPUT);
  pinMode(sensor, INPUT);
  
  //OUTPUT
  pinMode(Led1, OUTPUT);
  pinMode(Led2, OUTPUT);
  pinMode(Led3, OUTPUT);
  
  //comunicação serial
  Serial.begin(9600);
}

void loop()
{
   //Obtem tempo atual
   unsigned long currentMillis = millis();

  //prints
  Serial.println(sensorLumiValue);
  
  // le o valor do botão
  valorBtn = digitalRead(btn);
  if(valorBtn == 0){
    previousMillisBtn = currentMillis;
    if(contBtn == 3){
      contBtn = 0;
    }else{
      contBtn++;
    }
  }
  
  // read the value from the sensor:
  sensorLumiValue = analogRead(sensorLumiPin);    
  if(sensorLumiValue <= 230){
    cont = 0;
  } else if(sensorLumiValue > 230 && sensorLumiValue <=400){
    cont = 1;
  } else if(sensorLumiValue > 400 && sensorLumiValue <= 500){
    cont = 2;
  } else if(sensorLumiValue > 500){
    cont = 3;
  }
  
  //verifica o sensor e liga os leds
  valorSensor = digitalRead(sensor);
  
  if(currentMillis - previousMillisBtn > BtnInterval){
   
  if(valorSensor == 1){
    if(cont == 1 || cont == 2 || cont == 3){
         previousMillis = currentMillis;
    }
    if(cont == 0){
        digitalWrite(Led1, LOW);
      digitalWrite(Led2, LOW);
        digitalWrite(Led3, LOW);
    }else if(cont == 1){
      digitalWrite(Led1, HIGH);
        digitalWrite(Led2, LOW);
        digitalWrite(Led3, LOW);
    } else if(cont == 2){
      digitalWrite(Led1, HIGH);
        digitalWrite(Led2, HIGH);
        digitalWrite(Led3, LOW);
    }else if(cont == 3){
      digitalWrite(Led1, HIGH);
        digitalWrite(Led2, HIGH);
        digitalWrite(Led3, HIGH);
    }
  }
    
   if(currentMillis - previousMillis > redLedInterval){
      digitalWrite(Led1, LOW);
        digitalWrite(Led2, LOW);
        digitalWrite(Led3, LOW);
    }
  }else{
    if(contBtn == 0){
        digitalWrite(Led1, LOW);
      digitalWrite(Led2, LOW);
        digitalWrite(Led3, LOW);
    }else if(contBtn == 1){
      digitalWrite(Led1, HIGH);
        digitalWrite(Led2, LOW);
        digitalWrite(Led3, LOW);
    } else if(contBtn == 2){
      digitalWrite(Led1, HIGH);
        digitalWrite(Led2, HIGH);
        digitalWrite(Led3, LOW);
    }else if(contBtn == 3){
      digitalWrite(Led1, HIGH);
        digitalWrite(Led2, HIGH);
        digitalWrite(Led3, HIGH);
    }
  }
  
  
  delay(150);
    
}
