package unibo.disi.conwaygui;
import java.util.concurrent.TimeUnit;

import unibo.disi.conwaygui.devices.ConwayOutput;



public class LifeController {
    private int generationTime = 1000;
    private  Life life;
    private IOutDev outdev;
	private boolean stop;

    public LifeController(Life game){  
        this.life = game;
		this.stop = false;
        configureTheSystem();
     }

    protected void configureTheSystem() {
		//CommUtils.outyellow("LifeController | doJob ");
		life.createGrids();
        outdev = new ConwayOutput(   );		
    }
    
    //Called by ConwayInputMock
    public void start(){
		System.out.println("---------Initial----------");
		//La griglia è visualizzata con un ciclo
		displayGrid();
		play(); 		   	
    }
    
    protected void play() {
		int i = 1;
		this.stop = false;
		while (!stop) {
		//for( int i=1;i<=5;i++){
			try {
				TimeUnit.MILLISECONDS.sleep(generationTime);
				System.out.println("---------Epoch --- "+ i );
				life.computeNextGen( );
				//La griglia è visualizzata  'on the fly'
				displayGrid();
				i++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}    	
    }

	public void stop(){
		this.stop = true;
	}

	public void clear(){
		life.resetGrids();
		displayGrid();
	}
	public void displayGrid() {
		for (int i = 0; i < life.getRowsNum(); i++) {
			for (int j = 0; j < life.getColsNum(); j++) {
				if (!life.isCellAlive(i, j)) {
					outdev.displayCell("0");
                } else {
                	outdev.displayCell("1");
                }				 
			}
			outdev.displayCell("\n");
		}
	}

}
