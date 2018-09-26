import java.util.ArrayList;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;

class createBigCubes{
	
	static ArrayList<Box> BigCubes = new ArrayList<Box>(12);
	
	static ArrayList<Rotate> BClrtRotate = new ArrayList<Rotate>(12);
	static ArrayList<Rotate> BCurtRotate = new ArrayList<Rotate>(12);
	
	double BCx[] = new double[] {1.0, 1.0, 1.0, 1.0,
			956.0, 956.0, 956.0, 956.0, 
			956.0, 956.0, 956.0, 956.0
	};
	double BCy[] = new double[] {956.0, 956.0, 956.0, 956.0, 
			1.0, 1.0, 1.0, 1.0,
			956.0, 956.0, 956.0, 956.0
	};
	double BCz[] = new double[] {956.0, 956.0, 956.0, 956.0, 
			956.0, 956.0, 956.0, 956.0, 
			1.0, 1.0, 1.0, 1.0
	};
	PhongMaterial BGm[] = new PhongMaterial[] {new PhongMaterial(Color.RED), new PhongMaterial(Color.web("rgba(136,91,53,0.5)")), new PhongMaterial(Color.web("rgba(136,91,53,0.5)")), new PhongMaterial(Color.ORANGE),
			new PhongMaterial(Color.WHITE), new PhongMaterial(Color.web("rgba(136,91,53,0.5)")), new PhongMaterial(Color.web("rgba(136,91,53,0.5)")), new PhongMaterial(Color.YELLOW),
			new PhongMaterial(Color.GREEN), new PhongMaterial(Color.web("rgba(136,91,53,0.5)")), new PhongMaterial(Color.web("rgba(136,91,53,0.5)")), new PhongMaterial(Color.BLUE)
	};
	static double BCxt[] = new double[] {-162.5, -161.5, 161.5, 162.5,
			0, 0, 0, 0,
			0, 0, 0, 0
	};
	static double BCyt[] = new double[] {0, 0, 0, 0,
			-162.5, -161.5, 161.5, 162.5,
			0, 0, 0, 0
	};
	static double BCzt[] = new double[] {0, 0, 0, 0,	
			0, 0, 0, 0,
			-162.5, -161.5, 161.5, 162.5
	};

	public createBigCubes() {
		for(int i = 0; i<12; i++) {
			BigCubes.add(new Box(BCx[i], BCy[i], BCz[i]));
			BigCubes.get(i).setMaterial(BGm[i]);
			Translate translate = new Translate(rubikCube.Xm + BCxt[i], rubikCube.Ym + BCyt[i], rubikCube.Zm + BCzt[i]);
			BigCubes.get(i).getTransforms().add(translate);
		}
	}
	
	static void createBClrt() {
		for(int i = 0; i<12; i++) {
			BClrtRotate.add(new Rotate(0,-BCxt[i],-BCyt[i],-BCzt[i],Rotate.Y_AXIS));
			BigCubes.get(i).getTransforms().add(BClrtRotate.get(i));
		}
	}
	
	static void createBCurt() {
		for(int i = 0; i<12; i++) {
			BCurtRotate.add(new Rotate(0,-BCxt[i],-BCyt[i],-BCzt[i],Rotate.X_AXIS));
			BigCubes.get(i).getTransforms().add(BCurtRotate.get(i));
		}
	}
}