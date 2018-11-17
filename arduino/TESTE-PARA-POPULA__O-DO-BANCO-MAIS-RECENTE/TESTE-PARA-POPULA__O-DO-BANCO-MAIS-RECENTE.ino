const int Led1            = 7;
const int Led2            = 6;
const int Led3            = 5;

void setup()
{
  
  //OUTPUT
  pinMode(Led1, OUTPUT);
  pinMode(Led2, OUTPUT);
  pinMode(Led3, OUTPUT);
  
  //comunicação serial
  Serial.begin(9600);
}

void loop()
{

  Serial.println("1-HIGH");
  delay(5000); 
//  Serial.println("2-HIGH");
//  delay(5000); 
//  Serial.println("3-HIGH"); delay(5000); 
  Serial.println("1-LOW"); delay(5000); 
//  Serial.println("2-LOW"); delay(5000); 
//  Serial.println("3-LOW"); delay(5000); 
}
