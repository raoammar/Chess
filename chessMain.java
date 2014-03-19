// student id: 2824199,2831996
//Ammar Tariq Kahn and Muhammad Usman
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.Transparency;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class chessMain {
	public static class Piece{		// Main class for all pieces
		public Color color;
		public String symbol;			// Unicode of piece
		public ArrayList<Point> possibleMoves;	//	List of all Possible moves
		public Piece(Color _color){
			color = _color;
		}
		public String symbol(){
			return symbol;
		}
		public ArrayList<Point> availableMoves(Tile tiles[][], Point from){			// This calculates the valid moves from all possible moves
			return new ArrayList<Point>();
		}
		public void updatePiece(int type){		// to update pawn to queen

		}
	}
	public static class King extends Piece{
		public King(Color _color){
			super(_color);
			symbol = "\u265A";
			possibleMoves = new ArrayList<Point>();  //possible moves of King
			possibleMoves.add(new Point(-1,-1));
			possibleMoves.add(new Point(-1,1));
			possibleMoves.add(new Point(1,-1));
			possibleMoves.add(new Point(-1,0));
			possibleMoves.add(new Point(0,-1));
			possibleMoves.add(new Point(0,1));
			possibleMoves.add(new Point(1,0));
			possibleMoves.add(new Point(1,1));
		}
		public String symbol(){

			return symbol;
		}
		public ArrayList<Point> availableMoves(Tile tiles[][], Point from){
			 ArrayList<Point> availableMoves = new ArrayList<Point>();

			 for(Point move : possibleMoves){
			 	if(from.y+move.y > 7 || from.y+move.y < 0 ||
			 	from.x+move.x > 7 || from.x+move.x < 0)
			 		continue;
			 	if(tiles[from.y+move.y][from.x+move.x].piece == null){
			 		availableMoves.add(move);
			 	}else if(tiles[from.y+move.y][from.x+move.x].piece.color != color){
			 		availableMoves.add(move);
			 	}

			 }

			 return availableMoves;
		}
	}

	public static class Queen extends Piece{
		public Queen(Color _color){
			super(_color);
			symbol = "\u265B";
			possibleMoves = new ArrayList<Point>();		// possible moves of queen

			//diagonally up
			possibleMoves.add(new Point(-1,-1));
			possibleMoves.add(new Point(-2,-2));
			possibleMoves.add(new Point(-3,-3));
			possibleMoves.add(new Point(-4,-4));
			possibleMoves.add(new Point(-5,-5));
			possibleMoves.add(new Point(-6,-6));
			possibleMoves.add(new Point(-7,-7));

			possibleMoves.add(new Point(-1,1));
			possibleMoves.add(new Point(-2,2));
			possibleMoves.add(new Point(-3,3));
			possibleMoves.add(new Point(-4,4));
			possibleMoves.add(new Point(-5,5));
			possibleMoves.add(new Point(-6,6));
			possibleMoves.add(new Point(-7,7));

			possibleMoves.add(new Point(1,-1));
			possibleMoves.add(new Point(2,-2));
			possibleMoves.add(new Point(3,-3));
			possibleMoves.add(new Point(4,-4));
			possibleMoves.add(new Point(5,-5));
			possibleMoves.add(new Point(6,-6));
			possibleMoves.add(new Point(7,-7));

			possibleMoves.add(new Point(1,1));
			possibleMoves.add(new Point(2,2));
			possibleMoves.add(new Point(3,3));
			possibleMoves.add(new Point(4,4));
			possibleMoves.add(new Point(5,5));
			possibleMoves.add(new Point(6,6));
			possibleMoves.add(new Point(7,7));


			possibleMoves.add(new Point(0,-1));
			possibleMoves.add(new Point(0,-2));
			possibleMoves.add(new Point(0,-3));
			possibleMoves.add(new Point(0,-4));
			possibleMoves.add(new Point(0,-5));
			possibleMoves.add(new Point(0,-6));
			possibleMoves.add(new Point(0,-7));

			possibleMoves.add(new Point(0,1));
			possibleMoves.add(new Point(0,2));
			possibleMoves.add(new Point(0,3));
			possibleMoves.add(new Point(0,4));
			possibleMoves.add(new Point(0,5));
			possibleMoves.add(new Point(0,6));
			possibleMoves.add(new Point(0,7));

			possibleMoves.add(new Point(-1,0));
			possibleMoves.add(new Point(-2,0));
			possibleMoves.add(new Point(-3,0));
			possibleMoves.add(new Point(-4,0));
			possibleMoves.add(new Point(-5,0));
			possibleMoves.add(new Point(-6,0));
			possibleMoves.add(new Point(-7,0));

			possibleMoves.add(new Point(1,0));
			possibleMoves.add(new Point(2,0));
			possibleMoves.add(new Point(3,0));
			possibleMoves.add(new Point(4,0));
			possibleMoves.add(new Point(5,0));
			possibleMoves.add(new Point(6,0));
			possibleMoves.add(new Point(7,0));

		}
		public String symbol(){

			return symbol;
		}
		public ArrayList<Point> availableMoves(Tile tiles[][], Point from){
			 ArrayList<Point> availableMoves = new ArrayList<Point>();

			mainloop :for(int j=0;j<=possibleMoves.size()-7;j+=7){

			 	innerloop :for(int i=0;i<=7;i++){
			 //	System.out.println("j "+j+" i="+i+" i+j="+(i+j)+" size="+possibleMoves.size());
			 	if(i+j>=possibleMoves.size())
			 		break mainloop;
			 		Point move = possibleMoves.get(i+j);
			 		if(from.y+move.y > 7 || from.y+move.y < 0 ||
			 			from.x+move.x > 7 || from.x+move.x < 0)
			 				continue;


			 		if(tiles[from.y+move.y][from.x+move.x].piece == null){
			 			availableMoves.add(move);
			 		}else if(tiles[from.y+move.y][from.x+move.x].piece.color == color){
			 			break innerloop;
			 		}else if(tiles[from.y+move.y][from.x+move.x].piece.color != color){
			 			availableMoves.add(move);
			 			break innerloop;
			 		}


			 	}
			 }




			 return availableMoves;
		}
	}

	public static class Rook extends Piece{
		public Rook(Color _color){
			super(_color);
			symbol = "\u265C";
			possibleMoves = new ArrayList<Point>();		// Possible moves of Rook



			possibleMoves.add(new Point(0,-1));
			possibleMoves.add(new Point(0,-2));
			possibleMoves.add(new Point(0,-3));
			possibleMoves.add(new Point(0,-4));
			possibleMoves.add(new Point(0,-5));
			possibleMoves.add(new Point(0,-6));
			possibleMoves.add(new Point(0,-7));

			possibleMoves.add(new Point(0,1));
			possibleMoves.add(new Point(0,2));
			possibleMoves.add(new Point(0,3));
			possibleMoves.add(new Point(0,4));
			possibleMoves.add(new Point(0,5));
			possibleMoves.add(new Point(0,6));
			possibleMoves.add(new Point(0,7));

			possibleMoves.add(new Point(-1,0));
			possibleMoves.add(new Point(-2,0));
			possibleMoves.add(new Point(-3,0));
			possibleMoves.add(new Point(-4,0));
			possibleMoves.add(new Point(-5,0));
			possibleMoves.add(new Point(-6,0));
			possibleMoves.add(new Point(-7,0));

			possibleMoves.add(new Point(1,0));
			possibleMoves.add(new Point(2,0));
			possibleMoves.add(new Point(3,0));
			possibleMoves.add(new Point(4,0));
			possibleMoves.add(new Point(5,0));
			possibleMoves.add(new Point(6,0));
			possibleMoves.add(new Point(7,0));
		}
		public String symbol(){

			return symbol;
		}

		public ArrayList<Point> availableMoves(Tile tiles[][], Point from){
			 ArrayList<Point> availableMoves = new ArrayList<Point>();

			 	mainloop :for(int j=0;j<=possibleMoves.size()-7;j+=7){

			 	innerloop :for(int i=0;i<=7;i++){
			 //	System.out.println("j "+j+" i="+i+" i+j="+(i+j)+" size="+possibleMoves.size());
			 	if(i+j>=possibleMoves.size())
			 		break mainloop;
			 		Point move = possibleMoves.get(i+j);
			 		if(from.y+move.y > 7 || from.y+move.y < 0 ||
			 			from.x+move.x > 7 || from.x+move.x < 0)
			 				continue;


			 		if(tiles[from.y+move.y][from.x+move.x].piece == null){
			 			availableMoves.add(move);
			 		}else if(tiles[from.y+move.y][from.x+move.x].piece.color == color){
			 			break innerloop;
			 		}else if(tiles[from.y+move.y][from.x+move.x].piece.color != color){
			 			availableMoves.add(move);
			 			break innerloop;
			 		}


			 	}
			 }

			 return availableMoves;
		}
	}

	public static class Bishop extends Piece{
		public Bishop(Color _color){
			super(_color);
			symbol = "\u265D";
				possibleMoves = new ArrayList<Point>();


			possibleMoves.add(new Point(-1,-1));
			possibleMoves.add(new Point(-2,-2));
			possibleMoves.add(new Point(-3,-3));
			possibleMoves.add(new Point(-4,-4));
			possibleMoves.add(new Point(-5,-5));
			possibleMoves.add(new Point(-6,-6));
			possibleMoves.add(new Point(-7,-7));

			possibleMoves.add(new Point(-1,1));
			possibleMoves.add(new Point(-2,2));
			possibleMoves.add(new Point(-3,3));
			possibleMoves.add(new Point(-4,4));
			possibleMoves.add(new Point(-5,5));
			possibleMoves.add(new Point(-6,6));
			possibleMoves.add(new Point(-7,7));

			possibleMoves.add(new Point(1,-1));
			possibleMoves.add(new Point(2,-2));
			possibleMoves.add(new Point(3,-3));
			possibleMoves.add(new Point(4,-4));
			possibleMoves.add(new Point(5,-5));
			possibleMoves.add(new Point(6,-6));
			possibleMoves.add(new Point(7,-7));

			possibleMoves.add(new Point(1,1));
			possibleMoves.add(new Point(2,2));
			possibleMoves.add(new Point(3,3));
			possibleMoves.add(new Point(4,4));
			possibleMoves.add(new Point(5,5));
			possibleMoves.add(new Point(6,6));
			possibleMoves.add(new Point(7,7));
		}
		public String symbol(){

			return symbol;
		}
		public ArrayList<Point> availableMoves(Tile tiles[][], Point from){
			 ArrayList<Point> availableMoves = new ArrayList<Point>();

				mainloop :for(int j=0;j<=possibleMoves.size()-7;j+=7){

			 	innerloop :for(int i=0;i<=7;i++){
			// 	System.out.println("j "+j+" i="+i+" i+j="+(i+j)+" size="+possibleMoves.size());
			 	if(i+j>=possibleMoves.size())
			 		break mainloop;
			 		Point move = possibleMoves.get(i+j);
			 		if(from.y+move.y > 7 || from.y+move.y < 0 ||
			 			from.x+move.x > 7 || from.x+move.x < 0)
			 				continue;


			 		if(tiles[from.y+move.y][from.x+move.x].piece == null){
			 			availableMoves.add(move);
			 		}else if(tiles[from.y+move.y][from.x+move.x].piece.color == color){
			 			break innerloop;
			 		}else if(tiles[from.y+move.y][from.x+move.x].piece.color != color){
			 			availableMoves.add(move);
			 			break innerloop;
			 		}


			 	}
			 }
			 return availableMoves;
		}
	}

	public static class Knight extends Piece{
		public Knight(Color _color){
			super(_color);
			symbol = "\u265E";
			possibleMoves = new ArrayList<Point>(); // Moves for Knight


			possibleMoves.add(new Point(-1,2));
			possibleMoves.add(new Point(-1,-2));

			possibleMoves.add(new Point(1,2));
			possibleMoves.add(new Point(1,-2));

			possibleMoves.add(new Point(2,-1));
			possibleMoves.add(new Point(-2,-1));

			possibleMoves.add(new Point(2,1));
			possibleMoves.add(new Point(-2,1));
		}
		public String symbol(){

			return symbol;
		}
		public ArrayList<Point> availableMoves(Tile tiles[][], Point from){
			 ArrayList<Point> availableMoves = new ArrayList<Point>();

			 for(Point move : possibleMoves){
			 	if(from.y+move.y > 7 || from.y+move.y < 0 ||
			 	from.x+move.x > 7 || from.x+move.x < 0)
			 		continue;
			 	if(tiles[from.y+move.y][from.x+move.x].piece == null){
			 		availableMoves.add(move);
			 	}else if(tiles[from.y+move.y][from.x+move.x].piece.color != color){
			 		availableMoves.add(move);
			 	}

			 }
			 return availableMoves;
		}
	}

	public static class Pawn extends Piece{
		public Pawn(Color _color){
			super(_color);
			symbol = "\u265F";
			// moves different for black and white so check subclass
		}
		public String symbol(){

			return symbol;
		}

		public void updatePiece(int type){

		}
		public ArrayList<Point> availableMoves(Tile tiles[][], Point from){
			 ArrayList<Point> availableMoves = new ArrayList<Point>();

			  for(Point move : possibleMoves){
			 	if(from.y+move.y > 7 || from.y+move.y < 0 ||
			 	from.x+move.x > 7 || from.x+move.x < 0)
			 		continue;
			 	if(tiles[from.y+move.y][from.x+move.x].piece == null && move.x==0){
			 		availableMoves.add(move);
			 	}else if(tiles[from.y+move.y][from.x+move.x].piece != null && tiles[from.y+move.y][from.x+move.x].piece.color != color && (move.x==1 || move.x==-1)){
			 		availableMoves.add(move);
			 	}

			 }

			 return availableMoves;
		}
	}


	public static class BlackKing extends King{
		public BlackKing(){
			super(Color.BLACK);


		}


	}
	public static class BlackQueen extends Queen{
		public BlackQueen(){
			super(Color.BLACK);



		}


	}
	public static class BlackRook extends Rook{
		public BlackRook(){
			super(Color.BLACK);


		}


	}
	public static class BlackBishop extends Bishop{
		public BlackBishop(){
			super(Color.BLACK);



		}


	}
	public static class BlackKnight extends Knight{
		public BlackKnight(){
			super(Color.BLACK);





		}


	}
	public static class BlackPawn extends Pawn{
		public BlackPawn(){
			super(Color.BLACK);

			possibleMoves = new ArrayList<Point>();


			possibleMoves.add(new Point(-1,-1));
			possibleMoves.add(new Point(1,-1));

			possibleMoves.add(new Point(0,-1));
			possibleMoves.add(new Point(0,-2));


		}

		public void updatePiece(int type){
			//0 == update pawn possiblemoves as it has taken 1st step
			//1 == update pawn make it as a queen -- covered below
			if(type==0){
				possibleMoves = new ArrayList<Point>();


				possibleMoves.add(new Point(-1,-1));
				possibleMoves.add(new Point(1,-1));

				possibleMoves.add(new Point(0,-1));


			}else if(type==1){


			}

		}

	}

	///////////////WHITIESSS
	public static class WhiteKing extends King{
		public WhiteKing(){
			super(Color.WHITE);



		}

	}
	public static class WhiteQueen extends Queen{
		public WhiteQueen(){
			super(Color.WHITE);
		}

	}
	public static class WhiteRook extends Rook{
		public WhiteRook(){
			super(Color.WHITE);
		}

	}
	public static class WhiteBishop extends Bishop{
		public WhiteBishop(){
			super(Color.WHITE);
		}

	}
	public static class WhiteKnight extends Knight{
		public WhiteKnight(){
			super(Color.WHITE);
		}

	}
	public static class WhitePawn extends Pawn{
		public WhitePawn(){
			super(Color.WHITE);

			possibleMoves = new ArrayList<Point>();


			possibleMoves.add(new Point(1,1));
			possibleMoves.add(new Point(-1,1));

			possibleMoves.add(new Point(0,1));
			possibleMoves.add(new Point(0,2));

		}

		public void updatePiece(int type){
			//0 == update pawn possiblemoves as it has taken 1st step
			//1 == update pawn make it as a queen -- covered below
			if(type==0){
				possibleMoves = new ArrayList<Point>();


				possibleMoves.add(new Point(1,1));
			possibleMoves.add(new Point(-1,1));

			possibleMoves.add(new Point(0,1));



			}else if(type==1){


			}

		}

	}

	public static class Tile{

		Point position;
		Piece piece;
		public Tile(Point _position, Piece _piece){
			position = _position;
			piece = _piece;
		}
	}
    public static class Board extends JPanel implements MouseMotionListener, MouseListener{
		public  int tileSize = 70;		// tile size of the board
        public Tile tiles[][];				// For holding pieces
        public Color tile1Color = new Color(240,217,181);
        public Color tile2Color = new Color(181,136,99);
        Queen queenReference;		//to convert pawn to queen;
		Piece pawn;
    	Point oldMouseOver;			//used to display cached availableMoves
    	Point oldMouseClick;			// Last mouse clicked tile point
    	Point oldMouseClickHover;		// After click the mouse hover position
    	Color lastMoved;		// last move (white or black)
    	JFrame window;			// window
		public void setupPieces(){
			oldMouseOver = new Point(-1,-1);		//out of board
			oldMouseClick = new Point(-1,-1);		//out of board
			oldMouseClickHover = new Point(-1,-1);
			lastMoved = Color.RED;			// Game can be started at any piece color
			tiles =  new Tile[8][8];
			 for (int y=0;y<8;y++) {
            	for(int x=0;x<8;x++){

            	if(y>=2 && y<=5){			//empty tiles
            		tiles[y][x] = new Tile(new Point(x,y),null);
            	}else{			//fill tiles with appropriate pieces
            		if(y<=1){	//blacks

            			if(y==0){
            			if(x==0 || x==7)
            				tiles[y][x] = new Tile(new Point(x,y), new WhiteRook());
	        			else if(x==1 || x==6)
            				tiles[y][x] = new Tile(new Point(x,y), new WhiteKnight());
            			else if(x==2 || x==5)
            				tiles[y][x] = new Tile(new Point(x,y), new WhiteBishop());
            			else if(x==3)
            				tiles[y][x] = new Tile(new Point(x,y), new WhiteQueen());
            			else if(x==4)
            				tiles[y][x] = new Tile(new Point(x,y), new WhiteKing());
            			}else
            				tiles[y][x] = new Tile(new Point(x,y), new WhitePawn());
            		}else{		//whites
            			if(y==7){
            			if(x==0 || x==7)
            				tiles[y][x] = new Tile(new Point(x,y), new BlackRook());
	        			else if(x==1 || x==6)
            				tiles[y][x] = new Tile(new Point(x,y), new BlackKnight());
            			else if(x==2 || x==5)
            				tiles[y][x] = new Tile(new Point(x,y), new BlackBishop());
            			else if(x==3)
            				tiles[y][x] = new Tile(new Point(x,y), new BlackQueen());
            			else if(x==4)
            				tiles[y][x] = new Tile(new Point(x,y), new BlackKing());
            			}else
            				tiles[y][x] = new Tile(new Point(x,y), new BlackPawn());
            		}
            	}



            	}
            }

		}
        public Board(JFrame _window) {
        queenReference = new Queen(Color.WHITE);
        	setupPieces();
        	window = _window;

//mcflurryoreo

	        addMouseMotionListener(this);
        	addMouseListener(this);
         //   fillCells = new ArrayList<Point>(25);
        }

        public void drawPieces(Graphics g){

        Font font = new Font("Arial Unicode MS", Font.PLAIN, tileSize);
		g.setFont(font);

		FontMetrics fontMetrics = g.getFontMetrics(font);
        for (int y=0;y<8;y++) {
            	for(int x=0;x<8;x++){
//	                int cellX = 10 + (fillCell.x * 10);
//	                int cellY = 10 + (fillCell.y * 10);
					Tile currentIterationTile = tiles[y][x];
					if(currentIterationTile.piece!=null){
					if(oldMouseClick.x == x && oldMouseClick.y == y){
						Color selected = new Color(currentIterationTile.piece.color.getRed(),
						currentIterationTile.piece.color.getGreen(),
						currentIterationTile.piece.color.getBlue(), 155);
						g.setColor(selected);
					}else
						g.setColor(currentIterationTile.piece.color);
		                g.drawString(currentIterationTile.piece.symbol(),x*tileSize, ((y+1)*tileSize)- fontMetrics.getDescent()+(tileSize/10));


		            }
                }
            }
        }

        public void drawBoard(Graphics g){

        for (int y=0;y<8;y++) {
            	for(int x=0;x<8;x++){
//	                int cellX = 10 + (fillCell.x * 10);
//	                int cellY = 10 + (fillCell.y * 10);
					if((x+y)%2==0)
	    	            g.setColor(tile1Color);
	                else
		                g.setColor(tile2Color);
	                g.fillRect(x*tileSize, y*tileSize, tileSize, tileSize);
                }
            }
        }

    	public void getCurrentTileMoves(Graphics g){
	    	if(oldMouseOver.x==-1 && oldMouseOver.y==-1)
    			return;

	    	Point currentTilePoint = oldMouseOver;
    		Tile currentTile = tiles[(int)currentTilePoint.getY()][(int)currentTilePoint.getX()];
    		if(currentTile.piece==null)
    			return;
    		if(currentTile.piece.color == lastMoved)
    			return;

    		//ArrayList<Point> possibleMoves = ;

    		Color green = new Color(0, 255,0, 128 );
			Font font = new Font("Arial Unicode MS", Font.PLAIN, tileSize);
		g.setFont(font);

		FontMetrics fontMetrics = g.getFontMetrics(font);
    		for(Point move : currentTile.piece.availableMoves(tiles,oldMouseOver)){

				if(oldMouseClickHover.x==(int)(move.getX()+currentTilePoint.getX()) && oldMouseClickHover.y==(int)(move.getY()+currentTilePoint.getY())){
					//draw possible move
					Tile currentIterationTile = tiles[oldMouseOver.y][oldMouseOver.x];
					Color selected = new Color(currentIterationTile.piece.color.getRed(),
						currentIterationTile.piece.color.getGreen(),
						currentIterationTile.piece.color.getBlue(), 155);
						g.setColor(selected);
		                g.drawString(currentIterationTile.piece.symbol(),oldMouseClickHover.x*tileSize, ((oldMouseClickHover.y+1)*tileSize)- fontMetrics.getDescent()+(tileSize/10));
				}
				g.setColor(green);
	            g.fillRect((int)(move.getX()+currentTilePoint.getX())*tileSize, (int)(move.getY()+currentTilePoint.getY())*tileSize, tileSize, tileSize);

    		}
    	}
		public void mouseMoved(MouseEvent e) {
        	//System.out.println("mousemoved");
        	Point currentTile = new Point(e.getX()/tileSize,e.getY()/tileSize);
			if(oldMouseClick.x!=-1 && oldMouseClick.y!=-1){
				//draw a moving
				if(oldMouseClickHover.x == currentTile.x && oldMouseClickHover.y==currentTile.y)
					return;
				oldMouseClickHover.x = currentTile.x;
				oldMouseClickHover.y = currentTile.y;
				repaint();
				return;
			}

			if(currentTile.x == oldMouseOver.getX() && currentTile.y == oldMouseOver.getY())
				return;
			repaint();
			oldMouseOver.setLocation(currentTile.x,currentTile.y);



        //	System.out.println( " (" + currentTile.x + "," + currentTile.y + ")");
    	}
    	public boolean checkMateCheck(){
    	Piece kingWhite=null;
    		Piece kingBlack=null;
    		Point kingWPoint = new Point(-1,-1);
    		Point kingBPoint = new Point(-1,-1);


    		for(int y = 0;y<=7;y++){
    			for(int x = 0;x<=7;x++){
    				Tile check = tiles[y][x];
    				if(check.piece==null)
    					continue;

    				if(check.piece.symbol()=="\u265A" && check.piece.color == Color.WHITE){
    					kingWhite = check.piece;

    					kingWPoint.setLocation(x,y);
    					System.out.println("KingW at "+kingWPoint.x+" "+kingWPoint.y);
    				}else if(check.piece.symbol()=="\u265A" && check.piece.color == Color.BLACK){
    					kingBlack = check.piece;

    					kingBPoint.setLocation(x,y);
    					System.out.println("KingB at "+kingBPoint.x+" "+kingBPoint.y);
    				}


    			}

    		}


    		//try looking ahead and move king to try if it still checks
    		ArrayList<Point> kingWMoves = kingWhite.availableMoves(tiles,new Point(kingWPoint.x,kingWPoint.y));

    		int Wchecks = 0;
    		if(checkCheck(new Point(kingWPoint.x,kingWPoint.y), new Point(kingBPoint.x,kingBPoint.y))==1){
    			Wchecks++;
    			System.out.println("White checks withoutmove");
    		}
    		for(Point move : kingWMoves){
    			System.out.println("Check if King White moves "+(kingWPoint.x+move.x)+" "+(kingWPoint.y+move.y));
    			if(checkCheck(new Point(kingWPoint.x+move.x,kingWPoint.y+move.y),new Point(kingBPoint.x+move.x,kingBPoint.y+move.y))==1){
    				Wchecks ++;
    				System.out.println("check White");
    			}
    		}

    		ArrayList<Point> kingBMoves = kingBlack.availableMoves(tiles,new Point(kingBPoint.x,kingBPoint.y));

    		int Bchecks = 0;
    		if(checkCheck(new Point(kingWPoint.x,kingWPoint.y),new Point(kingBPoint.x,kingBPoint.y))==2){
    			Bchecks++;
    			System.out.println("Black checks withoutmove");
    		}
    		for(Point move : kingBMoves){
    			System.out.println("Check if King Black moves "+(kingBPoint.x+move.x)+" "+(kingBPoint.y+move.y));
    			if(checkCheck(new Point(kingWPoint.x+move.x,kingWPoint.y+move.y),new Point(kingBPoint.x+move.x,kingBPoint.y+move.y))==2){
    				Bchecks ++;
    				System.out.println("Black checks");
    			}
    		}


	    	System.out.println("blackcheck "+Bchecks+" "+kingBMoves.size()+"  - Whitecheck="+Wchecks+" "+kingWMoves.size());
    		if((Bchecks>0 && Bchecks==kingBMoves.size()+1) || (Wchecks>0 && Wchecks==kingWMoves.size()+1))
    		return true;
    		return false;
    	}
    	public int checkCheck(){
    		return checkCheck(new Point(-1,-1),new Point(-1,-1));
    	}
    	public int checkCheck(Point kingWPoint, Point kingBPoint){
    		Piece kingWhite=null;
    		Piece kingBlack=null;
   // 		Point kingWPoint = new Point(-1,-1);
///    		Point kingBPoint = new Point(-1,-1);
			boolean findWKing = false;
			if(kingWPoint.x==-1 && kingWPoint.y==-1)
				findWKing = true;

			boolean findBKing = false;
			if(kingBPoint.x==-1 && kingBPoint.y==-1)
				findBKing = true;

    		ArrayList<Point> allBlackMoves = new ArrayList<Point>();
    		ArrayList<Point> allWhiteMoves = new ArrayList<Point>();
    		for(int y = 0;y<=7;y++){
    			for(int x = 0;x<=7;x++){
    				Tile check = tiles[y][x];
    				if(check.piece==null)
    					continue;

    				if(check.piece.symbol()=="\u265A" && check.piece.color == Color.WHITE){
    					kingWhite = check.piece;
    					if(findWKing)
    						kingWPoint.setLocation(x,y);
    				//	System.out.println("KingW at "+kingWPoint.x+" "+kingWPoint.y);
    				}else if(check.piece.symbol()=="\u265A" && check.piece.color == Color.BLACK){
    					kingBlack = check.piece;
    					if(findBKing)
    						kingBPoint.setLocation(x,y);
    				//	System.out.println("KingB at "+kingBPoint.x+" "+kingBPoint.y);
    				}else{
    					//get moves
    					for(Point move : check.piece.availableMoves(tiles,new Point(x,y))){

    						if(check.piece.color == Color.BLACK){
	    						allBlackMoves.add(new Point(move.x+x,move.y+y));
    						//	System.out.println("Black Avb moves "+(move.x+x)+" "+(move.y+y));
    						}
    						if(check.piece.color == Color.WHITE){
	    						allWhiteMoves.add(new Point(move.x+x,move.y+y));
    						//	System.out.println("White Avb moves "+(move.x+x)+" "+(move.y+y));
    						}

    					}
    				}

    			}



    		}

    		for(Point move : allBlackMoves){

    				if((move.x == kingWPoint.x && move.y == kingWPoint.y))
    				return 1;			//white check


    			}
    			for(Point move : allWhiteMoves){

    			if((move.x == kingBPoint.x && move.y == kingBPoint.y))
    				return 2;			//black check
				}
    		return 0;


    	}

    	public void mousePressed(MouseEvent e) {}
     	public void mouseExited(MouseEvent e) {}
    	public void mouseEntered(MouseEvent e) {}
    	public void mouseReleased(MouseEvent e) {}
    	public void mouseDragged(MouseEvent e) {}
		public void mouseClicked(MouseEvent e){
		Point currentTile = new Point(e.getX()/tileSize,e.getY()/tileSize);
			System.out.println("mouseclicked");

			if(oldMouseClick.x==currentTile.x && oldMouseClick.y==currentTile.y){
				oldMouseClick.setLocation(-1,-1);
				repaint();
				return;
			}else if(oldMouseClick.x==-1 && oldMouseClick.y==-1){
				Tile check = tiles[currentTile.y][currentTile.x];
				if(check.piece.color == lastMoved)
    				return;
				oldMouseClick.setLocation(currentTile.x,currentTile.y);
				repaint();
			}else{
				System.out.println("preform Move if possible");
				System.out.println("move "+oldMouseClick.x+" "+oldMouseClick.y+" to "+currentTile.x+" "+currentTile.y);

				Tile ActiveTile = tiles[oldMouseClick.y][oldMouseClick.x];
				if(ActiveTile.piece==null)
					return;
				if(ActiveTile.piece.color == lastMoved)
    			return;
				for( Point move : ActiveTile.piece.availableMoves(tiles,oldMouseClick)){
					if(move.x+oldMouseClick.x==currentTile.x && move.y+oldMouseClick.y==currentTile.y){
						//can move

						//check kill and everything.....
						Tile swap_temp = tiles[currentTile.y][currentTile.x];;
						swap_temp.piece = null;
						tiles[currentTile.y][currentTile.x] = tiles[oldMouseClick.y][oldMouseClick.x];
						tiles[oldMouseClick.y][oldMouseClick.x] = swap_temp;

						Tile moved_piece = tiles[currentTile.y][currentTile.x];
						if(moved_piece.piece.symbol()=="\u265F" && currentTile.y==7 && moved_piece.piece.color == Color.WHITE){
							moved_piece.piece.possibleMoves=queenReference.possibleMoves;
							moved_piece.piece.symbol=queenReference.symbol();
						}
						else if(moved_piece.piece.symbol()=="\u265F" && currentTile.y==0 && moved_piece.piece.color == Color.BLACK){
							moved_piece.piece.possibleMoves=queenReference.possibleMoves;
							moved_piece.piece.symbol=queenReference.symbol();
						}else if(moved_piece.piece.symbol()=="\u265F"){

							moved_piece.piece.updatePiece(0);
						}

						if(checkMateCheck())			//check for check mate
							JOptionPane.showMessageDialog(window,"Check Mate");
						else if(checkCheck()>0)				//check for check
							JOptionPane.showMessageDialog(window,"Check");
						lastMoved = moved_piece.piece.color;
						oldMouseClick.x = -1;
						oldMouseClick.y = -1;
						oldMouseClickHover.x = -1;
						oldMouseClickHover.y = -1;

						oldMouseOver.x = -1;
						oldMouseOver.y = -1;
						repaint();
						break;

					}

				}


			}
		}

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            drawBoard(g);

            getCurrentTileMoves(g);
            //highlightClicked(g);
            drawPieces(g);

          /*  g.setColor(Color.BLACK);
            g.drawRect(10, 10, 800, 500);

            for (int i = 10; i <= 800; i += 10) {
                g.drawLine(i, 10, i, 510);
            }

            for (int i = 10; i <= 500; i += 10) {
                g.drawLine(10, i, 810, i);
            }*/
        }



    }

    public static void main(String[] a) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception ex) {
                }


                JFrame window = new JFrame();		// initializing frame
                Board board = new Board(window);		// initializing board
				window.setUndecorated(true);
                window.setSize(board.tileSize*8,(board.tileSize*8));		// Setting the size of the window
                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                window.add(board);
                window.setVisible(true);

            }
        });
    }
}