import java.awt.Color;
import java.awt.Graphics;
import java.awt.Panel;

public class Balken {

	private int _hoehe;
	private int _breite;
	private int _x;
	private int _y;
	private int _stepY;
	private Panel _panel;

	
	

	Balken(){
		
	}
	
	Balken(int x, int y, int breite, int hoehe, int stepY, Panel panel) {
		this._hoehe = hoehe;
		this._breite = breite;
		this._x = x;
		this._y = y;
		this._stepY = stepY;
		this._panel = panel;
	}

	public int get_hoehe() {
		return _hoehe;
	}

	public void set_hoehe(int _hoehe) {
		this._hoehe = _hoehe;
	}

	public int get_breite() {
		return _breite;
	}

	public void set_breite(int _breite) {
		this._breite = _breite;
	}
	
	public int get_x() {
		return _x;
	}

	public void set_x(int _x) {
		this._x = _x;
	}

	public int get_y() {
		return _y;
	}

	public void set_y(int _y) {
		this._y = _y;
	}

	public int get_stepY() {
		return _stepY;
	}

	public void set_stepY(int _stepY) {
		this._stepY = _stepY;
	}

	public Panel get_panel() {
		return _panel;
	}

	public void set_panel(Panel _panel) {
		this._panel = _panel;
	}

	public void move() {

		if (_y <= 0) {
			_y = 0;

		} else if (_y >= _panel.getHeight() - _hoehe) {
			_y = _panel.getHeight() - _hoehe;

		} else {
			//_y = _y + _stepY;
		}

	}

	public void zeichnen() {
		Graphics leinwand = _panel.getGraphics();

		leinwand.setColor(Color.cyan);
		leinwand.fillRect(_x, _y, _breite, _hoehe);
	}
	public void thisIsANewMethod(){
	}

}
