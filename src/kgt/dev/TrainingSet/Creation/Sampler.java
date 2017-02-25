package kgt.dev.TrainingSet.Creation;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Sampler extends JPanel{
	
	private int w,h;
	
	private SampleData data;
	
	private boolean[][] pixelData;
	
	/**
	 * 
	 * @param newData sample data to add to the paint component
	 */
	public Sampler(SampleData newData){
		this.data = newData;
		this.pixelData = newData.bipolorMatrix();
		this.w = newData.getSampleMat().rows();
		this.h = newData.getSampleMat().cols();
	}
	
	/**
	 * Creates a panel of squares
	 */
	@Override
	public void paint(final Graphics g){
		
		if(this.data == null){
			return;
		}
		int x,y;
		
		int vCell = this.getHeight() / this.data.getHeight();
		int hCell = this.getWidth() / this.data.getWidth();
		
		g.setColor(Color.white);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		g.setColor(Color.black);
		
		for(y= 0; y < this.data.getHeight();y++){
			g.drawLine(0, y * vCell, this.getWidth(), y * vCell);
		}
		
		for(x= 0; x < this.data.getWidth();x++){
			g.drawLine(x*hCell, 0, x * hCell, this.getHeight());
		}
		
		//check to see if the pixel block is filled or not
		for(y = 0; y < this.data.getHeight(); y++){
			for(x = 0; x < this.data.getWidth();x++){
				if(this.pixelData[x][y]){
					g.fillRect(y*hCell, x * vCell, hCell, vCell);
				}
			}	
		}
		
		g.setColor(Color.black);
		g.drawRect(0, 0, this.getWidth()-1, this.getHeight()-1);
	}
}
