int sensor = 0;
int sensorLumiValue = 0;

const int Led1 = 7;
const int Led2 = 6;
const int Led3 = 5;

void setup() {
  // put your setup code here, to run once:
  pinMode(sensorLumiValue, INPUT);

  //comunicação serial
  Serial.begin(9600);
  
}

void loop() {
  // put your main code here, to run repeatedly:

  // printa o valor do sensor
  Serial.println(sensorLumiValue);

  // le o valor do sensor
  sensorLumiValue = analogRead(sensor);
  if(sensorLumiValue <= 230){
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
