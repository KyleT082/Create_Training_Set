package kgt.dev.TrainingSet.Test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;

import org.opencv.core.Core;

import kgt.dev.TrainingSet.Creation.Entry;
import kgt.dev.TrainingSet.Creation.Sampler;
import kgt.dev.TrainingSet.Creation.TrainingSet;
import kgt.dev.TrainingSet.Creation.ZipReader;
import kgt.dev.model.ImageMatrix;

public class Test {
	public static JFrame frame;
	
	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		File f= new File("C:\\Users\\Kyle\\Pictures\\letters.zip");
		ZipReader zip = ZipReader.getInstance(f);
		
		Entry e = new Entry(zip.getSetName(),zip.getImageSet(),20,20);
		
		//System.out.println(zip.getImageSet().get(0).getImgMatrix().dump());
		e.downSample();
		
		Sampler s = new Sampler(e.getTrainingSetList().getTrainingSet().get(5));
		frame = new JFrame("Test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		
		frame.add(s);
		
		frame.setVisible(true);
	}
}
