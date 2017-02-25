package kgt.dev.TrainingSet.Creation;

import org.opencv.core.Mat;

public class SampleData {
	
	private Mat data;
	
	private char symbol;

	private boolean[][] biPolarMatrix;
	
	/**
	 * @param newSymbol  character reference
	 * @param newData    the matrix data
	 */
	public SampleData(char newSymbol,Mat newData){
		this.symbol = newSymbol;
		this.data = newData;
		this.biPolarMatrix = new boolean[data.cols()][data.rows()];
	}
	
	/**
	 * Create a bi-polar matrix based on pixel value,
	 * black or white.
	 * 
	 * @return Bi-Polar Matrix of the image
	 */
	public boolean[][] bipolorMatrix(){
		for(int x =0; x < this.data.cols();x++){
			for(int y = 0; y < this.data.rows();y++){
				double[] index = data.get(x, y);
				
				if(index[0] > 0){
					biPolarMatrix[x][y] = false;
				}else{
					biPolarMatrix[x][y] = true;
				}
			}
		}
		return biPolarMatrix;
	}
	
	/**
	 * @return the character/symbol of the data
	 */
	public char getSymbol() {
		return symbol;
	}
	

	/**
	 * @return raw pixel value data of matrix
	 */
	public Mat getSampleMat(){
		return data;
	}
	
	/**
	 * @return mat height
	 */
	public int getHeight(){
		return data.cols();
	}
	/**
	 * @return mat width
	 */
	public int getWidth(){
		return data.rows();
	}
	
}
