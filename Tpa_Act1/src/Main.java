import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		ArbolHabilidadesDinamico<Habilidad> troll = new ArbolHabilidadesDinamico<>(
				new Habilidad("Troll", "Personaje", 0, 0, 100));
		ArbolHabilidadesDinamico<Habilidad> elfo = new ArbolHabilidadesDinamico<>(
				new Habilidad("Elfo", "Personaje", 0, 0, 100));

		ArbolHabilidadesSecuencial<Habilidad> enano = new ArbolHabilidadesSecuencial<>(
				new Habilidad("Enano", "Personaje", 0, 0, 100));
		ArbolHabilidadesSecuencial<Habilidad> humano = new ArbolHabilidadesSecuencial<>(
				new Habilidad("Humano", "Personaje", 0, 0, 100));

		Habilidad ataqueTroll = new Habilidad("Ataque", "Categoría", 0, 0, 100);
		Habilidad defensaTroll = new Habilidad("Defensa", "Categoría", 0, 0, 100);
		troll.agregarHabilidad(troll.getRaiz(), ataqueTroll, defensaTroll);

		Habilidad ArcanoAtaqueTroll = new Habilidad("Arcano", "Ataque", 0, 0, 100);
		Habilidad ShadowAtaqueTroll = new Habilidad("Sombras", "Ataque", 0, 0, 100);
		troll.agregarHabilidad(ataqueTroll, ArcanoAtaqueTroll, ShadowAtaqueTroll);

		Habilidad ArcanoDefensaTroll = new Habilidad("Arcano", "Defensa", 0, 0, 100);
		Habilidad ShadowDefensaTroll = new Habilidad("Sombras", "Defensa", 0, 0, 100);
		troll.agregarHabilidad(defensaTroll, ArcanoDefensaTroll, ShadowDefensaTroll);

		troll.agregarHabilidad(ArcanoAtaqueTroll,
				new Habilidad("Explosion Arcana", "Ataque especifico de una rama de talentos", 0, 0, 100),
				new Habilidad("Deflagacion Arcana", "Ataque especifico de una rama de talentos", 0, 0, 100));
		troll.agregarHabilidad(ShadowAtaqueTroll,
				new Habilidad("Explosion mental", "Ataque especifico de una rama de talentos", 0, 0, 100),
				new Habilidad("Toque de las sombras", "Ataque especifico de una rama de talentos", 0, 0, 100));

		troll.agregarHabilidad(ArcanoDefensaTroll,
				new Habilidad("Arcane Barrage", "Defensa especifica de una rama de talentos", 0, 0, 100),
				new Habilidad("Escudo de mana", "Defensa especifica de una rama de talentos", 0, 0, 100));
		troll.agregarHabilidad(ShadowDefensaTroll,
				new Habilidad("Forma de las sombras", "Defensa especifica de una rama de talentos", 0, 0, 100),
				new Habilidad("Escudo de vacio abisal", "Defensa especifica de una rama de talentos", 0, 0, 100));

		Habilidad ataqueElfo = new Habilidad("Ataque", "Categoria", 0, 0, 100);
		Habilidad defensaElfo = new Habilidad("Defensa", "Categoria", 0, 0, 100);
		elfo.agregarHabilidad(elfo.getRaiz(), ataqueElfo, defensaElfo);

		Habilidad vientoAtaqueElfo = new Habilidad("Viento", "Ataque", 0, 0, 100);
		Habilidad tierraAtaqueElfo = new Habilidad("Tierra", "Ataque", 0, 0, 100);
		elfo.agregarHabilidad(ataqueElfo, vientoAtaqueElfo, tierraAtaqueElfo);

		Habilidad vientoDefensaElfo = new Habilidad("Viento", "Defensa", 0, 0, 100);
		Habilidad tierraDefensaElfo = new Habilidad("Tierra", "Defensa", 0, 0, 100);
		elfo.agregarHabilidad(defensaElfo, vientoDefensaElfo, tierraDefensaElfo);

		elfo.agregarHabilidad(vientoAtaqueElfo,
				new Habilidad("Corte de Viento", "Ataque especifico de una rama de talentos", 0, 0, 100),
				new Habilidad("Ventisca", "Ataque especifico de una rama de talentos", 0, 0, 100));
		elfo.agregarHabilidad(tierraAtaqueElfo,
				new Habilidad("Terremoto", "Ataque especifico de una rama de talentos", 0, 0, 100),
				new Habilidad("Avalancha", "Ataque especifico de una rama de talentos", 0, 0, 100));

		elfo.agregarHabilidad(vientoDefensaElfo,
				new Habilidad("Muro de Viento", "Defensa especifica de una rama de talentos", 0, 0, 100),
				new Habilidad("Ciclon", "Defensa especifica de una rama de talentos", 0, 0, 100));
		elfo.agregarHabilidad(tierraDefensaElfo,
				new Habilidad("Escudo de Tierra", "Defensa especifica de una rama de talentos", 0, 0, 100),
				new Habilidad("Fortaleza de Piedra", "Defensa especifica de una rama de talentos", 0, 0, 100));

		Habilidad ataqueEnano = new Habilidad("Ataque", "Categoria", 0, 0, 100);
		Habilidad defensaEnano = new Habilidad("Defensa", "Categoria", 0, 0, 100);
		enano.agregarHabilidad(null, ataqueEnano, defensaEnano);

		Habilidad hieloAtaqueEnano = new Habilidad("Hielo", "Ataque", 0, 0, 100);
		Habilidad fuegoAtaqueEnano = new Habilidad("Fuego", "Ataque", 0, 0, 100);
		enano.agregarHabilidad(ataqueEnano, hieloAtaqueEnano, fuegoAtaqueEnano);

		Habilidad hieloDefensaEnano = new Habilidad("Hielo", "Defensa", 0, 0, 100);
		Habilidad fuegoDefensaEnano = new Habilidad("Fuego", "Defensa", 0, 0, 100);
		enano.agregarHabilidad(defensaEnano, hieloDefensaEnano, fuegoDefensaEnano);

		Habilidad ataqueFuego = new Habilidad("Piroexplosion", "Ataque especifico de una rama de talentos", 0, 0, 100);
		Habilidad ataqueFuego2 = new Habilidad("Bola de fuego", "Ataque especifico de una rama de talentos", 0, 0, 100);
		enano.agregarHabilidad(fuegoAtaqueEnano, ataqueFuego, ataqueFuego2);

		Habilidad ataqueHielo = new Habilidad("Descarga de escarcha", "Ataque especifico de una rama de talentos", 0, 0,
				100);
		Habilidad ataqueHielo2 = new Habilidad("Ring of Frost", "Ataque especifico de una rama de talentos", 0, 0, 100);
		enano.agregarHabilidad(hieloAtaqueEnano, ataqueHielo, ataqueHielo2);

		Habilidad defensafuego1 = new Habilidad("Escudo de fuego", "Defensa especifica de una rama de talentos", 0, 0,
				100);
		Habilidad defensafuego2 = new Habilidad("Cauterizar", "Defensa especifica de una rama de talentos", 0, 0, 100);
		enano.agregarHabilidad(fuegoDefensaEnano, defensafuego1, defensafuego2);

		Habilidad defensahielo3 = new Habilidad("Venas Heladas", "Defensa especifica de una rama de talentos", 0, 0,
				100);
		Habilidad defensahielo4 = new Habilidad("Escudo de hielo", "Defensa especifica de una rama de talentos", 0, 0,
				100);
		enano.agregarHabilidad(hieloDefensaEnano, defensahielo3, defensahielo4);

		Habilidad ataqueHumano = new Habilidad("Ataque", "Categoría", 0, 0, 100);
		Habilidad defensaHumano = new Habilidad("Defensa", "Categoría", 0, 0, 100);
		humano.agregarHabilidad(null, ataqueHumano, defensaHumano);

		Habilidad hieloAtaqueHumano = new Habilidad("Hielo", "Ataque", 0, 0, 100);
		Habilidad fuegoAtaqueHumano = new Habilidad("Fuego", "Ataque", 0, 0, 100);
		humano.agregarHabilidad(ataqueHumano, hieloAtaqueHumano, fuegoAtaqueHumano);

		Habilidad hieloDefensaHumano = new Habilidad("Hielo", "Defensa", 0, 0, 100);
		Habilidad fuegoDefensaHumano = new Habilidad("Fuego", "Defensa", 0, 0, 100);
		humano.agregarHabilidad(defensaHumano, hieloDefensaHumano, fuegoDefensaHumano);

		Habilidad ataqueFuegoH = new Habilidad("Fireblast", "Ataque especifico de una rama de talentos", 0, 0, 100);
		Habilidad ataqueFuego2H = new Habilidad("Dragon Breath", "Ataque especifico de una rama de talentos", 0, 0,
				100);
		humano.agregarHabilidad(fuegoAtaqueHumano, ataqueFuegoH, ataqueFuego2H);

		Habilidad ataqueHieloH = new Habilidad("Ice Lance", "Ataque especifico de una rama de talentos", 0, 0, 100);
		Habilidad ataqueHielo2H = new Habilidad("Blizzard", "Ataque especifico de una rama de talentos", 0, 0, 100);
		humano.agregarHabilidad(hieloAtaqueHumano, ataqueHieloH, ataqueHielo2H);

		Habilidad defensafuego1H = new Habilidad("Escudo de llamas", "Defensa especifica de una rama de talentos", 0, 0,
				100);
		Habilidad defensafuego2H = new Habilidad("Avivar", "Defensa especifica de una rama de talentos", 0, 0, 100);
		humano.agregarHabilidad(fuegoDefensaHumano, defensafuego1H, defensafuego2H);

		Habilidad defensahielo3H = new Habilidad("Ice Cube", "Defensa especifica de una rama de talentos", 0, 0, 100);
		Habilidad defensahielo4H = new Habilidad("Escudo de escarcha", "Defensa especifica de una rama de talentos", 0,
				0, 100);
		humano.agregarHabilidad(hieloDefensaHumano, defensahielo3H, defensahielo4H);

		System.out.println("Arbol de habilidades del Troll (Arbol dinamico):");
		troll.imprimirArbol();

		System.out.println("\nArbol de habilidades del Elfo: (Arbol dinamico):");
		elfo.imprimirArbol();

		System.out.println("\nArbol de habilidades del Enano (Arbol secuencial):");
		enano.imprimirArbol();

		System.out.println("\nArbol de habilidades del Humano (Arbol secuencial):");
		humano.imprimirArbol2();

		Scanner scanner = new Scanner(System.in);
		System.out.println("Bienvenido al juego de batallas.");
		System.out.println("Jugador 1: Elige un personaje (1: Elfo, 2: Troll, 3: Enano, 4: Humano)");
		int j1 = scanner.nextInt();

		System.out.println("Jugador 2: Elige un personaje (1: Elfo, 2: Troll, 3: Enano, 4: Humano)");
		int j2 = scanner.nextInt();

		ArbolHabilidadesDinamico<Habilidad> jugador1dinamico = null;
		ArbolHabilidadesDinamico<Habilidad> jugador2dinamico = null;
		ArbolHabilidadesSecuencial<Habilidad> jugador1secuencial = null;
		ArbolHabilidadesSecuencial<Habilidad> jugador2secuencial = null;

		switch (j1) {
		case 1:
			jugador1dinamico = elfo;
			break;
		case 2:
			jugador1dinamico = troll;
			break;
		case 3:
			jugador1secuencial = enano;
			break;
		case 4:
			jugador1secuencial = humano;
			break;
		}

		switch (j2) {
		case 1:
			jugador2dinamico = elfo;
			break;
		case 2:
			jugador2dinamico = troll;
			break;
		case 3:
			jugador2secuencial = enano;
			break;
		case 4:
			jugador2secuencial = humano;
			break;
		}

		System.out.println(
				"Jugador 1 ha seleccionado: " + (jugador1dinamico != null ? jugador1dinamico.getRaiz().getNombre()
						: jugador1secuencial.getRaiz().getNombre()));
		System.out.println(
				"Jugador 2 ha seleccionado: " + (jugador2dinamico != null ? jugador2dinamico.getRaiz().getNombre()
						: jugador2secuencial.getRaiz().getNombre()));
		System.out.println("");
		System.out.println("Jugador 1, selecciona tu habilidad de ataque:");
		List<Habilidad> habilidadesAtaqueJ1 = (jugador1dinamico != null) ? jugador1dinamico.getHabilidadesDeAtaque()
				: jugador1secuencial.getHabilidadesDeAtaque();
		for (int i = 0; i < habilidadesAtaqueJ1.size(); i++) {
			Habilidad habilidad = habilidadesAtaqueJ1.get(i);
			System.out.println((i + 1) + ": " + habilidad.getNombre() + " (" + habilidad.getTipo() + ")");
		}
		int eleccionAtaqueJ1 = scanner.nextInt() - 1;
		Habilidad habilidadAtaqueSeleccionadaJ1 = habilidadesAtaqueJ1.get(eleccionAtaqueJ1);

		System.out.println("Jugador 2, selecciona tu habilidad de defensa:");
		List<Habilidad> habilidadesDefensaJ2 = (jugador2dinamico != null) ? jugador2dinamico.getHabilidadesDeDefensa()
				: jugador2secuencial.getHabilidadesDeDefensa();
		for (int i = 0; i < habilidadesDefensaJ2.size(); i++) {
			Habilidad habilidad = habilidadesDefensaJ2.get(i);
			System.out.println((i + 1) + ": " + habilidad.getNombre() + " (" + habilidad.getTipo() + ")");
		}
		int eleccionDefensaJ2 = scanner.nextInt() - 1;
		Habilidad habilidadDefensaSeleccionadaJ2 = habilidadesDefensaJ2.get(eleccionDefensaJ2);

		System.out.println("");

		System.out.println("Jugador 2, selecciona tu habilidad de ataque:");
		List<Habilidad> habilidadesAtaqueJ2 = (jugador2dinamico != null) ? jugador2dinamico.getHabilidadesDeAtaque()
				: jugador2secuencial.getHabilidadesDeAtaque();
		for (int i = 0; i < habilidadesAtaqueJ2.size(); i++) {
			Habilidad habilidad = habilidadesAtaqueJ2.get(i);
			System.out.println((i + 1) + ": " + habilidad.getNombre() + " (" + habilidad.getTipo() + ")");
		}
		int eleccionAtaqueJ2 = scanner.nextInt() - 1;
		Habilidad habilidadAtaqueSeleccionadaJ2 = habilidadesAtaqueJ2.get(eleccionAtaqueJ2);

		System.out.println("Jugador 1, selecciona tu habilidad de defensa:");
		List<Habilidad> habilidadesDefensaJ1 = (jugador1dinamico != null) ? jugador1dinamico.getHabilidadesDeDefensa()
				: jugador1secuencial.getHabilidadesDeDefensa();
		for (int i = 0; i < habilidadesDefensaJ1.size(); i++) {
			Habilidad habilidad = habilidadesDefensaJ1.get(i);
			System.out.println((i + 1) + ": " + habilidad.getNombre() + " (" + habilidad.getTipo() + ")");
		}
		int eleccionDefensaJ1 = scanner.nextInt() - 1;
		Habilidad habilidadDefensaSeleccionadaJ1 = habilidadesDefensaJ1.get(eleccionDefensaJ1);

		scanner.close();

		System.out.println("Atributos del Jugador 1:");
		if (jugador1dinamico != null) {
			System.out.println("Personaje: " + jugador1dinamico.getRaiz().getNombre() + " (Salud: "
					+ jugador1dinamico.getRaiz().getPuntosSalud() + ", Ataque: "
					+ jugador1dinamico.getRaiz().getPuntosAtaque() + ", Defensa: "
					+ jugador1dinamico.getRaiz().getPuntosDefensa() + ")");
			System.out.println("Ataque: " + habilidadAtaqueSeleccionadaJ1.getNombre());
			System.out.println("Defensa: " + habilidadDefensaSeleccionadaJ1.getNombre());
		} else {
			System.out.println("Personaje: " + jugador1secuencial.getRaiz().getNombre() + " (Salud: "
					+ jugador1secuencial.getRaiz().getPuntosSalud() + ", Ataque: "
					+ jugador1secuencial.getRaiz().getPuntosAtaque() + ", Defensa: "
					+ jugador1secuencial.getRaiz().getPuntosDefensa() + ")"
					+ " Estadísticas iniciales. Cambiara en cada turno");
			System.out.println("Ataque: " + habilidadAtaqueSeleccionadaJ1.getNombre());
			System.out.println("Defensa: " + habilidadDefensaSeleccionadaJ1.getNombre());
		}

		
		System.out.println("\nAtributos del Jugador 2:");
		if (jugador2dinamico != null) {
			System.out.println("Personaje: " + jugador2dinamico.getRaiz().getNombre() + " (Salud: "
					+ jugador2dinamico.getRaiz().getPuntosSalud() + ", Ataque: "
					+ jugador2dinamico.getRaiz().getPuntosAtaque() + ", Defensa: "
					+ jugador2dinamico.getRaiz().getPuntosDefensa() + ")"
					+ " Estadísticas iniciales. Cambiara en cada turno");
			System.out.println("Ataque: " + habilidadAtaqueSeleccionadaJ2.getNombre());
			System.out.println("Defensa: " + habilidadDefensaSeleccionadaJ2.getNombre());
		} else {
			System.out.println("Personaje: " + jugador2secuencial.getRaiz().getNombre() + " (Salud: "
					+ jugador2secuencial.getRaiz().getPuntosSalud() + ", Ataque: "
					+ jugador2secuencial.getRaiz().getPuntosAtaque() + ", Defensa: "
					+ jugador2secuencial.getRaiz().getPuntosDefensa() + ")"
					+ " Estadísticas iniciales. Cambiara en cada turno");
			System.out.println("Ataque: " + habilidadAtaqueSeleccionadaJ2.getNombre());
			System.out.println("Defensa: " + habilidadDefensaSeleccionadaJ2.getNombre());
		}

		int max_turnos = 100;
		int turnos = 0;

		while (turnos < max_turnos
			    && (jugador1dinamico != null ? jugador1dinamico.getRaiz().getPuntosSalud() > 0
			            : jugador1secuencial.getRaiz().getPuntosSalud() > 0)
			    && (jugador2dinamico != null ? jugador2dinamico.getRaiz().getPuntosSalud() > 0
			            : jugador2secuencial.getRaiz().getPuntosSalud() > 0)) {
			    habilidadAtaqueSeleccionadaJ1.generarAtaque(); 
			    habilidadDefensaSeleccionadaJ2.generarDefensa(); 
			    habilidadAtaqueSeleccionadaJ2.generarAtaque();
			    habilidadDefensaSeleccionadaJ1.generarDefensa();
		    if (turnos % 2 == 0) {
		        
		        System.out.println("\nTurno " + (turnos + 1) + ": Jugador 1 ataca con "
		                + habilidadAtaqueSeleccionadaJ1.getNombre());
		        System.out.println("Poder de ataque: " + habilidadAtaqueSeleccionadaJ1.getPuntosAtaque());
		        System.out.println("Defensa de Jugador 2: " + habilidadDefensaSeleccionadaJ2.getPuntosDefensa());
		        int danioInfligidoJ1 = habilidadAtaqueSeleccionadaJ1.getPuntosAtaque()
		                - habilidadDefensaSeleccionadaJ2.getPuntosDefensa();
		        if (danioInfligidoJ1 < 0) {
		            danioInfligidoJ1 = 0; // No puede infligir daño negativo
		        }
		        int puntosSaludRestantesJ2 = (jugador2dinamico != null ? jugador2dinamico.getRaiz().getPuntosSalud()
		                : jugador2secuencial.getRaiz().getPuntosSalud()) - danioInfligidoJ1;
		        if (puntosSaludRestantesJ2 < 0) {
		            puntosSaludRestantesJ2 = 0; // No puede tener salud negativa
		        }
		        if (jugador2dinamico != null) {
		            jugador2dinamico.getRaiz().setPuntosSalud(puntosSaludRestantesJ2);
		        } else {
		            jugador2secuencial.getRaiz().setPuntosSalud(puntosSaludRestantesJ2);
		        }
		        System.out.println("Jugador 2 recibe " + danioInfligidoJ1 + " puntos de daño. Salud restante: "
		                + puntosSaludRestantesJ2);
		    } else {
		        
		        System.out.println("\nTurno " + (turnos + 1) + ": Jugador 2 ataca con "
		                + habilidadAtaqueSeleccionadaJ2.getNombre());
		        System.out.println("Poder de ataque: " + habilidadAtaqueSeleccionadaJ2.getPuntosAtaque());
		        System.out.println("Defensa de Jugador 1: " + habilidadDefensaSeleccionadaJ1.getPuntosDefensa());
		        int danioInfligidoJ2 = habilidadAtaqueSeleccionadaJ2.getPuntosAtaque()
		                - habilidadDefensaSeleccionadaJ1.getPuntosDefensa();
		        if (danioInfligidoJ2 < 0) {
		            danioInfligidoJ2 = 0; // No puede infligir daño negativo
		        }
		        int puntosSaludRestantesJ1 = (jugador1dinamico != null ? jugador1dinamico.getRaiz().getPuntosSalud()
		                : jugador1secuencial.getRaiz().getPuntosSalud()) - danioInfligidoJ2;
		        if (puntosSaludRestantesJ1 < 0) {
		            puntosSaludRestantesJ1 = 0; // No puede tener salud negativa
		        }
		        if (jugador1dinamico != null) {
		            jugador1dinamico.getRaiz().setPuntosSalud(puntosSaludRestantesJ1);
		        } else {
		            jugador1secuencial.getRaiz().setPuntosSalud(puntosSaludRestantesJ1);
		        }
		        System.out.println("Jugador 1 recibe " + danioInfligidoJ2 + " puntos de daño. Salud restante: "
		                + puntosSaludRestantesJ1);
		    }
		    turnos++;
		}


		
		int puntosSaludJ1 = jugador1dinamico != null ? jugador1dinamico.getRaiz().getPuntosSalud()
				: jugador1secuencial.getRaiz().getPuntosSalud();
		int puntosSaludJ2 = jugador2dinamico != null ? jugador2dinamico.getRaiz().getPuntosSalud()
				: jugador2secuencial.getRaiz().getPuntosSalud();

			if (puntosSaludJ1 > puntosSaludJ2) {
				System.out.println("\nEl ganador es Jugador 1.");
			} else if (puntosSaludJ2 > puntosSaludJ1) {
				System.out.println("\nEl ganador es Jugador 2.");
			} else {
				System.out.println("\nLa partida ha terminado en empate.");
			}
		}

	}
