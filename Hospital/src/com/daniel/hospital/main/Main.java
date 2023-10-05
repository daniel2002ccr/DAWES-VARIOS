package com.daniel.hospital.main;

import java.sql.SQLException;



import com.daniel.hospital.vistas.MenuPrincipal;


class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

	
		MenuPrincipal mp = new MenuPrincipal();
		mp.menuPrincipal();

	}

}
