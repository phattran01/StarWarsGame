
public class VillainFactory {
	

		public static Villain getInstance(Villains name) {
			Villain v = null;
			
				if(name.equals(Villains.KYLO_REN)) 
					v = new KyloRen();
				
				else if(name.equals(Villains.DARTH_VADAR))
					v = new Vadar();
					
				
				else if(name.equals(Villains.EMPEROR_PALPATINE))
					v = new EmpPalp();
				
				else if(name.equals(Villains.DARTH_BANE))
					v = new Bane();
			
			return v;
		}
		
		
	}


//