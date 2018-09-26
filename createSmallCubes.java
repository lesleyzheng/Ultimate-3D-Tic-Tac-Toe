import java.util.ArrayList;
import java.util.List;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;
import javafx.scene.transform.Translate;

class createSmallCubes{
	
	private static double[] xAlts = new double[] {-105, 0, 105, -105, 0, 105, -105, 0, 105, //back
			-105, 0, 105, -105, 105, -105, 0, 105,  //middle
			-105, 0, 105, -105, 0, 105, -105, 0, 105 //front
			};
	private static double[] yAlts = new double[] {105, 105, 105, 0, 0, 0, -105, -105, -105,
			105, 105, 105, 0, 0, -105, -105, -105,
			105, 105, 105, 0, 0, 0, -105, -105, -105
	};
	private static double[] zAlts = new double[] {-105, -105, -105, -105, -105, -105, -105, -105, -105,
			0, 0, 0, 0, 0, 0, 0, 0,
			105, 105, 105, 105, 105, 105, 105, 105, 105
			};
	
	private static double[] sXm = new double[] {- 323, 0, + 323, - 323, 0, + 323, - 323, 0, + 323,
			- 323, 0, + 323, - 323, + 323, - 323, 0, + 323,
			- 323, 0, + 323, - 323, 0, + 323, - 323, 0, + 323
	};
	private static double [] sYm = new double[] {0 + 323, 0 + 323, 0 + 323, 0, 0, 0, 0 - 323, 0 - 323, 0 - 323,
			0 + 323, 0 + 323, 0 + 323, 0, 0, 0 - 323, 0 - 323, 0 - 323,
			0 + 323, 0 + 323, 0 + 323, 0, 0, 0, 0 - 323, 0 - 323, 0 - 323
	};
	private static double[] sZm = new double[] {0 - 323, 0 - 323, 0 - 323, 0 - 323, 0 - 323, 0 - 323, 0 - 323, 0 - 323, 0 - 323,
			0, 0, 0, 0, 0, 0, 0, 0,
			0 + 323, 0 + 323, 0 + 323, 0 + 323, 0 + 323, 0 + 323, 0 + 323, 0 + 323, 0 + 323
	};
	
	private PhongMaterial[] materials = new PhongMaterial[] {new PhongMaterial(Color.RED), new PhongMaterial(Color.RED), new PhongMaterial(Color.RED), new PhongMaterial(Color.RED), new PhongMaterial(Color.RED), new PhongMaterial(Color.RED), new PhongMaterial(Color.RED), new PhongMaterial(Color.RED), new PhongMaterial(Color.RED),
			new PhongMaterial(Color.WHITE), new PhongMaterial(Color.WHITE), new PhongMaterial(Color.WHITE), new PhongMaterial(Color.WHITE), new PhongMaterial(Color.WHITE), new PhongMaterial(Color.WHITE), new PhongMaterial(Color.WHITE), new PhongMaterial(Color.WHITE),
			new PhongMaterial(Color.BLUE), new PhongMaterial(Color.BLUE), new PhongMaterial(Color.BLUE), new PhongMaterial(Color.BLUE), new PhongMaterial(Color.BLUE), new PhongMaterial(Color.BLUE), new PhongMaterial(Color.BLUE), new PhongMaterial(Color.BLUE), new PhongMaterial(Color.BLUE)
	};
	
	static List<List<Box>> SmallCubes = new ArrayList<List<Box>>();

	static List<List<Rotate>> SBlrtRotate = new ArrayList<List<Rotate>>();
	static List<List<Rotate>> SBurtRotate = new ArrayList<List<Rotate>>();
			
	public createSmallCubes() {
		for(int i = 0; i<26; i++) {
			List<Box> temp = new ArrayList<Box>();
			for(int j = 0; j<26; j++) {
				temp.add(new Box(100,100,100));
				temp.get(j).setMaterial(materials[j]);
				Translate translate = new Translate(rubikCube.Xm + sXm[i] + xAlts[j],rubikCube.Ym + sYm[i] + yAlts[j],rubikCube.Zm + sZm[i] + zAlts[j]);
				temp.get(j).getTransforms().add(translate);
			}
			SmallCubes.add(temp);
		}
	}

	static void createSBlrt() {
		for(int i = 0; i<26; i++) {
			List<Rotate> rotate1 = new ArrayList<Rotate>();
			for(int j = 0; j<26; j++) {
				rotate1.add(new Rotate(0, -1*xAlts[j]-1*sXm[i],-1*yAlts[j]-1*sYm[i],-1*zAlts[j]-1*sZm[i], Rotate.Y_AXIS));
				SmallCubes.get(i).get(j).getTransforms().add(rotate1.get(j));
			}
			SBlrtRotate.add(rotate1);
		}
	}
	
	static void createSBurt() {
		for(int i = 0; i<26; i++) {
			List<Rotate> rotate2 = new ArrayList<Rotate>();
			for(int j = 0; j<26; j++) {
				rotate2.add(new Rotate(0, -1*xAlts[j]-1*sXm[i],-1*yAlts[j]-1*sYm[i],-1*zAlts[j]-1*sZm[i], Rotate.X_AXIS));
				SmallCubes.get(i).get(j).getTransforms().add(rotate2.get(j));
			}
			SBurtRotate.add(rotate2);
		}
	}
}