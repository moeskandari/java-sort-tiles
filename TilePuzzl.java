
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;




public class TilePuzzl extends JFrame implements ActionListener  {
    public TilePiece[] tile = new TilePiece[12];
    public TilePiece blankTile = null;

    public TilePuzzl()
    {
        JFrame window = new JFrame("infoLab Lights: Play me!");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(475, 400);
        window.setLocationRelativeTo(null);
        
        //making a panel 
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,4));
     
        for (int row = 0, index = 0;row < 3; row ++){
            for(int col = 0; col <4; col ++, index ++){
                if (index == 0){
                    //create the blank tile on top left corner 
                    tile[index] = new TilePiece("blank_tile.jpg", row, col);
                    blankTile = tile[index];
                }
                else{
                    //create rest of the ties 
                    tile[index] = new TilePiece("tiles/tile_" + index + ".jpg", row, col);
                }

                //add the panel to the set of action listners 
                panel.add(tile[index]);
                tile[index].addActionListener(this);
            }

        }
        
        
        
        //add the panel on the window 
        window.setContentPane(panel);
        //make the window visible
        window.setVisible(true);
    }
    //action perrformer 
    public void actionPerformed(ActionEvent e)
    {
        System.out.println("Tile clicked!"); // Debug print

        TilePiece clickedTile = (TilePiece) e.getSource(); // get an object reference to the tile which has been pressed
        
        //check if the button presses is ajasent to blank piece 
        if (clickedTile.isAdjacentTo(blankTile)){
            System.out.println("Swapping " + clickedTile.getXPos() + "," + clickedTile.getYPos() + 
                               " with " + blankTile.getXPos() + "," + blankTile.getYPos());


            clickedTile.exchangeImageWith(blankTile); //swap the image 
            
            // Swap positions (to maintain correct adjacency logic)
            int tempX = clickedTile.getXPos();
            int tempY = clickedTile.getYPos();
            clickedTile.setPosition(blankTile.getXPos(), blankTile.getYPos());
            blankTile.setPosition(tempX, tempY);
            
            
            //update the blank tile 
            blankTile = clickedTile;
            
        }

    }

}
