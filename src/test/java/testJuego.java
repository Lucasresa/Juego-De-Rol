import javax.swing.JOptionPane;
import javax.xml.ws.handler.MessageContext;

import juego.Jugador;

public class testJuego {

	public static void main(String[] args) {
		
		Jugador caballero = new Jugador("Caballero",15,25);
		
		Jugador aldeano = new Jugador("Aldeano",5,15);
		
		//Contador de rondas
		int ronda=1;
		
		while(true) {
			
			caballero.atacarJugador(aldeano);
		
			//Verifico la vida del aldeano luego de ser atacado
			if(aldeano.getVida()==0) {
				JOptionPane.showMessageDialog(null, aldeano.getNombre()+" ha muerto, Ganó "+caballero.getNombre(), 
						"Ganador", JOptionPane.INFORMATION_MESSAGE);
				break;
			}
			
			aldeano.atacarJugador(caballero);
			
			//Verifico la vida del aldeano luego de ser atacado
			if(caballero.getVida()==0) {
				JOptionPane.showMessageDialog(null, caballero.getNombre()+" ha muerto, Ganó "+aldeano.getNombre(), 
						"Ganador", JOptionPane.INFORMATION_MESSAGE);
				break;
			}
			
			//Muestro la informacion de lo que sucedio en la ultima ronda
			JOptionPane.showMessageDialog(null,
					caballero.getNombre()+" Atacó a "+aldeano.getNombre()+" con "+caballero.getLastHit()+" de poder\n"+
					aldeano.getNombre()+" Atacó a "+caballero.getNombre()+" con "+aldeano.getLastHit()+" de poder\n"+
					"Vida "+caballero.getNombre()+" = "+caballero.getVida()+"\nVida "+aldeano.getNombre()+" = "+aldeano.getVida(), 
					"Informacion de Round "+ronda, JOptionPane.INFORMATION_MESSAGE
					);
			
			ronda++;
			
		}
		
		
		
	}

}
