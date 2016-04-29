package Svet;

import java.awt.*;
import java.awt.image.*;

import java.io.*;
import javax.imageio.ImageIO;

import pixla.HerniPanel;

public class Mapa {
	
	// position
	private double x;
	private double y;
	
	// bounds
	private int xmin;
	private int ymin;
	private int xmax;
	private int ymax;
	
	private double tween;
	
	// map
	private int[][] map;
	private int tileSize;
	private int numRows;
	private int numCols;
	private int width;
	private int height;
	
	// tileset
	private BufferedImage tileset;
	private int numTilesAcross;
	private Tile[][] tiles;
	
	// drawing
	private int rowOffset;
	private int colOffset;
	private int numRowsToDraw;
	private int numColsToDraw;
	
	public Mapa(int tileSize) {
		this.tileSize = tileSize;
		numRowsToDraw = HerniPanel.HEIGHT / tileSize + 2;
		numColsToDraw = HerniPanel.WIDTH / tileSize + 2;
		tween = 0.07;
	}
	
	public void loadTiles(String s) {
		
		try {

			tileset = ImageIO.read(
				getClass().getResourceAsStream("/Resources"+s)
			);
			numTilesAcross = tileset.getWidth() / tileSize;
			tiles = new Tile[1][numTilesAcross];
			
			BufferedImage subimage;
			for(int col = 0; col < numTilesAcross; col++) {
				subimage = tileset.getSubimage(
							col * tileSize,
							0,
							tileSize,
							tileSize
						);
				tiles[0][col] = new Tile(subimage, Tile.NORMAL);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void loadMap(String s) {
		
		/*try {
			
			InputStream in = getClass().getResourceAsStream("/Resources"+s);
			BufferedReader br = new BufferedReader(
						new InputStreamReader(in)
					);
			
			numCols = Integer.parseInt(br.readLine());
			numRows = Integer.parseInt(br.readLine());
			map = new int[numRows][numCols];
			width = numCols * tileSize;
			height = numRows * tileSize;
			
			xmin = HerniPanel.WIDTH - width;
			xmax = 0;
			ymin = HerniPanel.HEIGHT - height;
			ymax = 0;
			
			String delims = "\\s+";
			for(int row = 0; row < numRows; row++) {
				String line = br.readLine();
				String[] tokens = line.split(delims);
				for(int col = 0; col < numCols; col++) {
					map[row][col] = Integer.parseInt(tokens[col]);
				}
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
            
            numCols = 100;
            numRows = 50;
            width = numCols * tileSize;
            height = numRows * tileSize;
		
            map = new int[numRows][numCols];
            for (int i = 0; i < numRows; i++) {
                for (int j = 0; j < numCols; j++) {
                    if(j < 20) {
                        map[i][j] = -1;
                    }else if(j == 20){
                        map[i][j] = 0;
                    }else {
                        map[i][j] = 1;
                    }
                    int k = 40;
                    //if(i == k || j == k) map[i][j] = 2;
                }
            }
	}
	
	public int getTileSize() { return tileSize; }
	public double getx() { return x; }
	public double gety() { return y; }
	public int getWidth() { return width; }
	public int getHeight() { return height; }
	
	public int getType(int row, int col) {
		int rc = map[row][col];
		int r = rc / numTilesAcross;
		int c = rc % numTilesAcross;
		return tiles[r][c].getType();
	}
	
	public void setTween(double d) { tween = d; }
	
	public void setPosition(double x, double y) {
		
		this.x += (x - this.x) * tween;
		this.y += (y - this.y) * tween;
		
		fixBounds();
		
		colOffset = (int)-this.x / tileSize;
		rowOffset = (int)-this.y / tileSize;
		
	}
	
	private void fixBounds() {
		if(x < xmin) x = xmin;
		if(y < ymin) y = ymin;
		if(x > xmax) x = xmax;
		if(y > ymax) y = ymax;
	}
	
	public void draw(Graphics2D g) {
            /*int s = 1;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    g.drawImage(
					tiles[i][j].getImage(),
					(int)x + i * tileSize+10,
					(int)y + j * tileSize+10,
					null
				);
                    g.setColor(Color.WHITE);
                    g.drawRect((int)x + i * tileSize+10,(int)y + j * tileSize+10, tileSize, tileSize);
                    g.setColor(Color.red);
                    g.drawString(i+"-"+j+"-"+s++, (int)x + i * tileSize *6+10, (int)y + j * tileSize*2+130);
                }
            }*/
            
		for (int row = rowOffset; row < rowOffset + numRowsToDraw; row++) {
            for (int col = colOffset; col < colOffset + numColsToDraw; col++){
                
                if(col >= numCols || row >= numRows) break;
                if(map[col][row] == -1) continue;
                
                int rc = map[col][row];
                int r = rc / numTilesAcross;
                int c = rc % numTilesAcross;
                
                g.drawImage(
                        tiles[r][c].getImage(),
                        (int)x + col * tileSize,
                        (int)y + row * tileSize,
                        null
                );
                
            }
        }
		
	}

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
	
}



















