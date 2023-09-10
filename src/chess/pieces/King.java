package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

	public King(Board board, Color color) {
		super(board, color);
	}
	
	@Override
	public String toString() {
		return "K";
	}
	
	private boolean canMove(Position position) {
		ChessPiece piece = (ChessPiece) getBoard().piece(position);
		return piece == null || piece.getColor() != getColor();
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position position = new Position(0, 0);
		
//		above
		position.setValues(this.position.getRow() - 1, this.position.getColumn());
		if(getBoard().positionExists(position) && canMove(position)) {
			mat[position.getRow()][position.getColumn()] = true;
		}
		
//		above right diagonal
		position.setValues(this.position.getRow() - 1, this.position.getColumn() + 1);
		if(getBoard().positionExists(position) && canMove(position)) {
			mat[position.getRow()][position.getColumn()] = true;
		}

//		right
		position.setValues(this.position.getRow(), this.position.getColumn() + 1);
		if(getBoard().positionExists(position) && canMove(position)) {
			mat[position.getRow()][position.getColumn()] = true;
		}
		
//		below right diagonal
		position.setValues(this.position.getRow() + 1, this.position.getColumn() + 1);
		if(getBoard().positionExists(position) && canMove(position)) {
			mat[position.getRow()][position.getColumn()] = true;
		}
		
//		below
		position.setValues(this.position.getRow() + 1, this.position.getColumn());
		if(getBoard().positionExists(position) && canMove(position)) {
			mat[position.getRow()][position.getColumn()] = true;
		}
		
//		below left diagonal
		position.setValues(this.position.getRow() + 1, this.position.getColumn() - 1);
		if(getBoard().positionExists(position) && canMove(position)) {
			mat[position.getRow()][position.getColumn()] = true;
		}
		
//		left
		position.setValues(this.position.getRow(), this.position.getColumn() - 1);
		if(getBoard().positionExists(position) && canMove(position)) {
			mat[position.getRow()][position.getColumn()] = true;
		}
		
//		above left diagonal
		position.setValues(this.position.getRow() - 1, this.position.getColumn() - 1);
		if(getBoard().positionExists(position) && canMove(position)) {
			mat[position.getRow()][position.getColumn()] = true;
		}
		
		return mat;
	}

}
