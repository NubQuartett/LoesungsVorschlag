package de.uni_hamburg.informatik.swt.se2.mediathek.materialien;

import de.uni_hamburg.informatik.swt.se2.mediathek.materialien.medien.Medium;

public class Vormerkkarte {
	private Medium _medium;
	private Kunde _vormerker1;
	private Kunde _vormerker2;
	private Kunde _vormerker3;
	private Kunde _entleiher;
	
	public Vormerkkarte(Medium medium, Kunde entleiher){
		_medium = medium;
		_entleiher = entleiher;
	}
	
	public Kunde get_v1(){
		return _vormerker1;
	}
	
	public Kunde get_v2(){
		return _vormerker2;
	}
	
	public Kunde get_v3(){
		return _vormerker3;
	}
	
	public Kunde get_entleiher(){
		return _entleiher;
	}
	
	
	public void set_entleiher(Kunde entleiher){
		_entleiher = entleiher;
	}
	
	
	/**
	 * fügt an der letzten freie Stelle einen Vormerkr ein
	 */
	public void add_vormerker(Kunde vormerker){
		assert vormerker != null :"Es muss ein Kunde zum Vormerken angegeben werden.";
		assert vormerker != _entleiher :"Ein Medium kann nicht vom Entleiher vorgemerkt werden.";
		
		if(_vormerker1 == null){
			_vormerker1 = vormerker;
		}else if(_vormerker2 == null){
			_vormerker2 =vormerker;
		}else if(_vormerker3 == null){
			_vormerker3 = vormerker;
		}		
	}
	/**
	 * kontrolliert ob der Kunde das Medium vormerken kann
	 */
	
	
	
	/**
	 * wenn das Medium ausgeliehen wird rücken alle Vormerker eine Stelle nach vorne
	 */
	public void nachruecken(){
		_vormerker1 = _vormerker2;
		_vormerker2 = _vormerker3;
		_vormerker3 = null;
	}
	
	/**
	 * Kann der angegebenen Kunde das Medium vormerken
	 */
	
	public boolean istVormerkenMoeglich(Kunde kunde){
		assert kunde != null :"Es muss ein Kunde angegeben werden";
		if(kunde.equals(_entleiher)){
			return false;
		}
		if(kunde.equals(_vormerker1))
		{
			return false;
		}
		if(kunde.equals(_vormerker2)){
			return false;
		}
		if(kunde.equals(_vormerker3)){
			return false;
		}
		if(_vormerker3 != null){
			return false;
		}
		return true;
	}
	
	/**
	 * Darf der Kunde das Medium ausleihen
	 * @param kunde
	 * @return
	 */
	public boolean darfMediumverliehenwerden(Kunde kunde){
		return kunde == _vormerker1 || _vormerker1 == null;
	}
	
	public boolean istLeer(){
		if(_vormerker1 == null && _vormerker2 == null && _vormerker3 == null){
			return true;
		}
		return false;
	}
	
	
	
	
	
	
	

}
