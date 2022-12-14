public class King extends ChessPiece{

    public King(Board board, Color color) {
        super(board, color);
    }
    
    @Override
    public String toString(){
        return "K";
    }

    public boolean canMove(Position position){
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position p = new Position(0, 0);

        //Acima
        p.setValues(position.getRow() - 1, position.getColumn());
        if(getBoard().PositionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        //Abaixo
        p.setValues(position.getRow() + 1, position.getColumn());
        if(getBoard().PositionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }
        
        //esquerda
        p.setValues(position.getRow(), position.getColumn() - 1);
        if(getBoard().PositionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        //direita
        p.setValues(position.getRow(), position.getColumn() + 1);
        if(getBoard().PositionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        //NW
        p.setValues(position.getRow() - 1, position.getColumn() - 1);
        if(getBoard().PositionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        //NE
        p.setValues(position.getRow() - 1, position.getColumn() + 1);
        if(getBoard().PositionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }
        
        //SW
        p.setValues(position.getRow() + 1, position.getColumn() - 1);
        if(getBoard().PositionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        //SE
        p.setValues(position.getRow() + 1, position.getColumn() + 1);
        if(getBoard().PositionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        return mat;
    }
}
