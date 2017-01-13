package ru.job4j.actions;

import ru.job4j.exceptions.FigureNotFoundException;
import ru.job4j.exceptions.ImpossibleMoveException;
import ru.job4j.exceptions.OccupiedWayException;

/**
 * Created by VLADIMIR on 13.01.2017.
 */
public class MainClass {

    /**
     * Главный класс.
     * @param args args
     * @throws OccupiedWayException OccupiedWayException
     * @throws ImpossibleMoveException ImpossibleMoveException
     * @throws FigureNotFoundException FigureNotFoundException
     */
    public static void main(String[] args) throws OccupiedWayException, ImpossibleMoveException, FigureNotFoundException {

        //Figure figure = new FigureBishop(new Cell(4, 7));
        //Figure figure = new FigureRook(new Cell(4, 0));

        //Cell[] cells = figure.way(new Cell(1, 4));

//		for (Cell cell : cells){
//			if(cell != null){
//				System.out.println("Horisontal: " + cell.getHorisontal() + "; Vertical: " + cell.getVertical());
//			}
//		}

//        Board board = new Board();
//        board.move(new Cell(0, 0), new Cell(0, 2));
//        board.move(new Cell(0, 2), new Cell(0, 4));

        //	board.move(new Cell(0, 0), new Cell(0, 2));
        //Figure f = new Board().getFigure(new Cell(2, 0));

        //	if(f != null){
        //	System.out.println(f.getPosition().getHorisontal());
        //	System.out.println(f.getPosition().getVertical());
        //	}

    }
}
