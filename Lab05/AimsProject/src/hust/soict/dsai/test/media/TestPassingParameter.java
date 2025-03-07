package hust.soict.dsai.test.media;

import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class TestPassingParameter {
	public static void main(String[] args) {
		DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle", null, 0, 0, null);
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella", null, 0, 0, null);
		
		swap(jungleDVD,cinderellaDVD);
		System.out.println("jungle dvd title: "+ jungleDVD.getTitle());
		System.out.println("cinderella dvd title: "+ cinderellaDVD.getTitle());
		
		changeTitle(jungleDVD,cinderellaDVD.getTitle());
		System.out.println("jungle dvd title: "+ jungleDVD.getTitle());
	}
	public static void swap(Object o1, Object o2) {
		Object tmp = o1;
		o1 = o2;
		o2 = tmp;
	}
	public static void changeTitle(DigitalVideoDisc dvd, String title)
	{
		String oldTitle = dvd.getTitle();
		dvd.setTitle(title);
		dvd = new DigitalVideoDisc(oldTitle, oldTitle, 0, 0, oldTitle);
	}
}

