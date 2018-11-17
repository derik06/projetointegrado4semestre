int       cont            = 0;

const int Led1            = 7;
const int Led2            = 6;
const int Led3            = 5;

const int sensor          = 4;
int       sensorLumiPin   = 0;
int       sensorLumiValue = 0;

bool      valorSensor;

void setup()
{
  
  //OUTPUT
  pinMode(Led1, OUTPUT);
  pinMode(Led2, OUTPUT);
  pinMode(Led3, OUTPUT);

  pinMode(sensor, INPUT);
  
  //comunicação serial
  Serial.begin(9600);
}

void loop()
{

  // printa o valor do sensor
  Serial.println(sensorLumiValue);

  // le o valor do sensor
  sensorLumiValue = analogRead(sensorLumiPin);
  if(sensorLumiValue <= 230){
    cont = 0;
  } else if(sensorLumiValue > 230 && sensorLumiValue <=400){
    digitalWrite(Led1, HIGH);
    digitalWrite(Led2, HIGH);
    digitalWrite(Led3, HIGH);
  } else if(sensorLumiValue > 400 && sensorLumiValue <= 500){
    digitalWrite(Led1, HIGH);
    digitalWrite(Led2, HIGH);
    digitalWrite(Led3, LOW);
  } else if(sensorLumiValue > 500){
    digitalWrite(Led1, HIGH);
    digitalWrite(Led2, LOW);
    digitalWrite(Led3, LOW);
  }
    
  delay(150);
   
}
