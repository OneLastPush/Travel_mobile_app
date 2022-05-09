package com.birikfr.util;

public class Conversion {
	
	//Volume
	public static double lConversion(double l, int to){
		switch(to){
		//Liters
		case 1:
			return l;
		//Imperial Gallons
		case 2:
			return l/4.54609;
		//Milliliters
		case 3:
			return 1 * 1000;
		//Centiliters
		case 4:
			return l * 100;
		//Pints
		case 5:
			return l*1.75975;
		//Tablespoons
		case 6:
			return l*56.3121;
		default:
			return -1.0;
		}
	}
	public static double galConversion(double gal, int to){
		switch(to){
		//Liters
		case 1:
			return gal * 4.54609;
		//Imperial Gallons
		case 2:
			return gal;
		//Milliliters
		case 3:
			return gal *4546.09;
		//Centiliters
		case 4:
			return gal* 454.609188;
		//Pints
		case 5:
			return gal * 8;
		//Tablespoons
		case 6:
			return gal * 256;
		default:
			return -1.0;
		}
	}
	public static double mlConversion(double ml, int to){
		switch(to){
		//Liters
		case 1:
			return ml/1000;
		//Imperial Gallons
		case 2:
			return ml/4546.09;
		//Milliliters
		case 3:
			return ml;
		//Centiliters
		case 4:
			return ml/10;
		//Pints
		case 5:
			return ml/568.261;
		//Tablespoons
		case 6:
			return ml/17.7582;
		default:
			return -1.0;
		}
	}
	public static double clConversion(double cl, int to){
		switch(to){
		//Liters
		case 1:
			return cl/100;
		//Imperial Gallons
		case 2:
			return cl/454.609;
		//Milliliters
		case 3:
			return cl * 10;
		//Centiliters
		case 4:
			return cl;
		//Pints
		case 5:
			return cl/56.8261;
		//Tablespoons
		case 6:
			return cl/1.77582;
		default:
			return -1.0;
		}
	}
	public static double ptConversion(double pt, int to){
		switch(to){
		//Liters
		case 1:
			return pt/1.75975;
		//Imperial Gallons
		case 2:
			return pt/8;
		//Milliliters
		case 3:
			return pt * 568.261;
		//Centiliters
		case 4:
			return pt * 56.8261;
		//Pints
		case 5:
			return pt;
		//Tablespoons
		case 6:
			return pt * 32;
		default:
			return -1.0;
		}
	}
	public static double tbspConversion(double tbsp, int to){
		switch(to){
		//Liters
		case 1:
			return tbsp/56.3121;
		//Imperial Gallons
		case 2:
			return tbsp/256;
		//Milliliters
		case 3:
			return tbsp * 17.7582;
		//Centiliters
		case 4:
			return tbsp * 1.77581714;
		//Pints
		case 5:
			return tbsp/32;
		//Tablespoons
		case 6:
			return tbsp;
		default:
			return -1.0;
		}
	}
	//Weight
	public static double gConversion(double g, int to){
		switch(to){
		//Kg
		case 1:
			return g/1000;
		//Gram
		case 2:
			return g;
		//Metric Ton
		case 3:
			return g/100000;
		//Pound
		case 4:
			return g/453.592;
		//Ounce
		case 5:
			return g/28.3495;
		default:
			return -1.0;
		}
	}
	public static double ozConversion(double oz, int to){
		switch(to){
		//Kg
		case 1:
			return oz/35.274;
		//Gram
		case 2:
			return (oz * 28.3495);
		//Metric Ton
		case 3:
			return oz/35274;
		//Pound
		case 4:
			return oz/16;
		//Ounce
		case 5:
			return oz;
		default:
			return -1.0;
		}
	}
	public static double tonConversion(double ton, int to){
		switch(to){
		//Kg
		case 1:
			return ton * 1000;
		//Gram
		case 2:
			return (ton * 100000);
		//Metric Ton
		case 3:
			return ton;
		//Pound
		case 4:
			return ton*2204.62;
		//Ounce
		case 5:
			return ton * 35274;
		default:
			return -1.0;
		}
	}
	public static double lbConversion(double lb, int to){
		switch(to){
		//Kg
		case 1:
			return lb/2.20462;
		//Gram
		case 2:
			return (lb * 453.592);
		//Metric Ton
		case 3:
			return (lb/2204.62);
		//Pound
		case 4:
			return lb;
		//Ounce
		case 5:
			return lb * 16;
		default:
			return -1.0;
		}
	}
	public static double kgConversion(double kg, int to){
		switch(to){
		//Kg
		case 1:
			return kg;
		//Gram
		case 2:
			return (kg*1000);
		//Metric Ton
		case 3:
			return (kg/1000);
		//Pound
		case 4:
			return (kg * 2.20462);
		//Ounce
		case 5:
			return (kg * 35.274);
		default:
			return -1.0;
		}
	}
	
	//Distance 
	public static double cmConversion(double cm, int to){
		switch(to){
				//Centimeter
				case 1:
					return cm;
				//Feet
				case 2:
					return (cm/30.48);
				//Inch
				case 3:
					return (cm/2.54);
				//Kilometer
				case 4:
					return (cm * 100000);
				//Meter
				case 5:
					return (cm * 100);
				//Mile
				case 6:		
					return (cm * 160934);
				//Yard
				case 7:
					return (cm /91.44);
				default:
					return -1.0;
		}
	}
	public static double mConversion(double m, int to){
		switch(to){
				//Centimeter
				case 1:
					return (m*100);
				//Feet
				case 2:
					return (m * 3.28084);
				//Inch
				case 3:
					return (m * 39.3701);
				//Kilometer
				case 4:
					return (m/100);
				//Meter
				case 5:
					return m;
				//Mile
				case 6:		
					return (m / 1609.34);
				//Yard
				case 7:
					return (m * 1.09361);
				default:
					return -1.0;
		}
	}
	public static double kmConversion(double km, int to){
		switch(to){
				//Centimeter
				case 1:
					return (km*100000);
				//Feet
				case 2:
					return (km * 3280.84);
				//Inch
				case 3:
					return (km * 39370.1);
				//Kilometer
				case 4:
					return km;
				//Meter
				case 5:
					return km * 1000;
				//Mile
				case 6:		
					return (km / 1.60934);
				//Yard
				case 7:
					return (km * 1093.61);
				default:
					return -1.0;
		}
	}
	public static double inchConversion(double inch, int to){
		switch(to){
				//Centimeter
				case 1:
					return (inch*2.54);
				//Feet
				case 2:
					return (inch/12);
				//Inch
				case 3:
					return inch;
				//Kilometer
				case 4:
					return inch/39370.1;
				//Meter
				case 5:
					return inch/39.3701;
				//Mile
				case 6:		
					return (inch / 63360);
				//Yard
				case 7:
					return (inch /36);
				default:
					return -1.0;
		}
	}
	public static double feetConversion(double feet, int to){
		switch(to){
				//Centimeter
				case 1:
					return (feet*30.48);
				//Feet
				case 2:
					return feet;
				//Inch
				case 3:
					return feet * 12;
				//Kilometer
				case 4:
					return feet/3280.84;
				//Meter
				case 5:
					return feet/3.28084;
				//Mile
				case 6:		
					return (feet / 5280);
				//Yard
				case 7:
					return ( feet/3);
				default:
					return -1.0;
		}
	}
	public static double mileConversion(double mile, int to){
		switch(to){
				//Centimeter
				case 1:
					return (mile*160934);
				//Feet
				case 2:
					return mile*5280;
				//Inch
				case 3:
					return mile*63360;
				//Kilometer
				case 4:
					return mile*1.60934;
				//Meter
				case 5:
					return mile * 1609.34;
				//Mile
				case 6:		
					return mile;
				//Yard
				case 7:
					return (mile * 1760);
				default:
					return -1.0;
		}
	}
	public static double yardConversion(double yard, int to){
		switch(to){
				//Centimeter
				case 1:
					return yard *91.44;
				//Feet
				case 2:
					return yard * 3;
				//Inch
				case 3:
					return yard*36;
				//Kilometer
				case 4:
					return yard/1093.61;
				//Meter
				case 5:
					return yard/1.09361;
				//Mile
				case 6:		
					return (yard / 1760);
				//Yard
				case 7:
					return yard;
				default:
					return -1.0;
		}
	}
}
