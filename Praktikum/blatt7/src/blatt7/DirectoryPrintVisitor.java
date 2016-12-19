package blatt7;

import java.io.File;

public class DirectoryPrintVisitor implements DirectoryVisitor {

	int d = 0;

	@Override
	public void enterDirectory(File dir) {
		d++;
		for (int i = 0; i < d; i++) {
			System.out.print("  ");
		}

		System.out.println("*Ordner : " + dir.getAbsolutePath()
				+ "    \n *Name des Ordners : " + dir.getName()
				+ "    \n *Göße des Ordners in B :" + dir.length() 
				+ "B");

	}

	@Override
	public void leaveDirectory(File dir) {
		d--;

	}

	@Override
	public void visitFile(File file) {
		for (int i = 0; i < d; i++) {
			System.out.print("  ");
		}
		System.out.println(file.getName());
	}

}