import java.awt.*;
import java.awt.event.*;

public class Ball {

	private int _x;
	private int _y;
	private int _groesse;
	private int _stepInX;
	private int _stepInY;
	Panel panelSpiel = new Panel();

	Ball(int x, int y, int groesse, int stepInX, int stepInY, Panel panel) {
		this._x = x;
		this._y = y;
		this._groesse = groesse;
		this._stepInX = stepInX;
		this._stepInY = stepInY;
		this.panelSpiel = panel;

	}

	public void set_x(int x) {
		this._x = x;
	}

	public int get_x() {
		return this._x;
	}

	public void set_y(int y) {
		this._y = y;
	}

	public int get_y() {
		return this._y;
	}

	public void set_groesse(int groesse) {
		this._groesse = groesse;
	}

	public int get_groesse() {
		return this._groesse;
	}

	public void set_stepInX(int stepInX) {
		this._stepInX = stepInX;
	}

	public int get_stepInX() {
		return this._stepInX;
	}

	public void set_stepInY(int stepInY) {
		this._stepInY = stepInY;
	}

	public int get_stepInY() {
		return this._stepInY;
	}

	public void set_panel(Panel panel) {
		this.panelSpiel = panel;
	}

	public Panel get_panel() {
		return this.panelSpiel;
	}

	public void move() {

		if (_y == 0) {
			_stepInY = -_stepInY;
		}

		if (_y + _groesse >= (panelSpiel.getHeight())) {
			_stepInY = -_stepInY;
		}

		if (_x == 0) {
			_stepInX = -_stepInX;
		}

		if (_x + _groesse >= (panelSpiel.getWidth())) {
			_stepInX = -_stepInX;
		}

		_x = _x + _stepInX;
		_y = _y + _stepInY;

	}

	public void zeichnen() {
		Graphics leinwand = panelSpiel.getGraphics();

		leinwand.setColor(Color.RED);
		leinwand.fillOval(_x, _y, _groesse, _groesse);
	}

}
