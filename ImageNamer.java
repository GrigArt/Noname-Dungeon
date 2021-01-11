
public class ImageNamer {
	String FN;
	char[] FileCharName;
	ImageNamer(){
	}
	public String getName(String FileName) {
		FN = FileName;
		FileCharName = new char[(FN.length())];
		FileCharName = FileName.toCharArray();
		FN = FN.replaceAll(".png", ".txt");
		return FN;
	}

}
