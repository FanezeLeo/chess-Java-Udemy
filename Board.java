public class Board {
    private int rows;
    private int columns;
    private Piece [][] pieces;

    public Board(int rows, int columns) {
        if(rows < 1 || columns < 1){
            throw new BoardException("Erro: É necessario que haja mais de 1 linha ou coluna no tabuleiro.");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Piece piece(int row, int column){
        if(!PositionExists(row, column)){
            throw new BoardException("Erro: Está posição não Existe no tabuleiro.");
        }
        return pieces[row][column];
    }

    public Piece piece(Position position){
        if(!PositionExists(position)){
            throw new BoardException("Erro: Está posição não Existe no tabuleiro.");
        }
        return pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece, Position position){
        if(thereIsAPiece(position)){
            throw new BoardException("Ja existe uma peça nesta posição: " + position);
        }
        pieces[position.getRow()] [position.getColumn()] = piece;
        piece.position = position;
    }

    public boolean PositionExists(Position position){
        return PositionExists(position.getRow(), position.getColumn());
    }

    private boolean PositionExists(int row, int column){
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }

    public boolean thereIsAPiece(Position position){
        if(!PositionExists(position)){
            throw new BoardException("Erro: Está posição não Existe no tabuleiro.");
        }
        return piece(position) != null;
    }

    public Piece removePiece(Position position){
        if(!PositionExists(position)){
            throw new BoardException("Erro: Está posição não Existe no tabuleiro.");
        }

        if(piece(position) == null){
            return null;
        }

        Piece aux = piece(position);
        aux.position = null;
        pieces[position.getRow()][position.getColumn()] = null;

        return aux;
    }
}
