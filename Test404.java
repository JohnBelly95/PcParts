public class Test404{
	public static void main(String[] args) {
		PcParts i54670k = new CPU(3.4,4,"i5-4670k","Intel",2013,200); 
		System.out.println(i54670k);
		PcParts Z87k = new Motherboard("Intel",32,7,"Z87-K","Asus",2013,112);
		System.out.println(Z87k);
		PcParts topkek = new CPU();
		System.out.println(topkek);
		PcParts BlackWidow = new Keyboard("Wired","Black Widow","Razer",2014,100);
		System.out.println(BlackWidow);
		BlackWidow.setPrice(220);
		System.out.println(BlackWidow);
	}
}
