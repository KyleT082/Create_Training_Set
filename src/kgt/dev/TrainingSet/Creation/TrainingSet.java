package kgt.dev.TrainingSet.Creation;

import java.util.ArrayList;
import java.util.List;

import org.opencv.core.Mat;

public class TrainingSet {
	
	private List<SampleData> trainingSet;
	
	private String setName;
	
	/**
	 * @param newSetName  Name of the Font type
	 */
	public TrainingSet(String newSetName){
		this.setName = newSetName;
		trainingSet = new ArrayList<SampleData>(); 
	}
	
	/**
	 * @param data
	 */
	public void add(SampleData data){
		trainingSet.add(data);
	}
	
	/**
	 * @return the training sets data
	 */
	public List<SampleData> getTrainingSet(){
		return trainingSet;
	}
	
	/**
	 * @return the training set name
	 */
	public String getSetName(){
		return setName;
	}
}
