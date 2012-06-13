package monopoly.objects;

import java.io.IOException;
import java.io.InputStream;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.jogl.JoglApplication;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.loaders.ModelLoaderRegistry;
import com.badlogic.gdx.graphics.g3d.materials.Material;
import com.badlogic.gdx.graphics.g3d.materials.TextureAttribute;
import com.badlogic.gdx.graphics.g3d.model.keyframe.KeyframedAnimation;
import com.badlogic.gdx.graphics.g3d.model.keyframe.KeyframedModel;
import com.badlogic.gdx.graphics.g3d.model.keyframe.KeyframedSubMesh;
import com.badlogic.gdx.graphics.glutils.ImmediateModeRenderer10;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;

public class AnimatedObject
{
	public KeyframedModel mesh;
	public Texture diffuseTex;
	public KeyframedAnimation[] animations;
	
	public boolean isTransparent;
	
	public AnimatedObject(String meshFileName, String diffuseFileName, boolean isTransparent) throws IOException
	{
		this.isTransparent = isTransparent;
		
		mesh = ModelLoaderRegistry.loadKeyframedModel
				(Gdx.files.internal("data/" + meshFileName + ".md2"));
		
		if (isTransparent)
		{
			diffuseTex = new Texture
					(Gdx.files.internal("data/" + diffuseFileName), Format.RGBA8888, true);
		}
		else
		{
			diffuseTex = new Texture
					(Gdx.files.internal("data/" + diffuseFileName), Format.RGB565, true);
		}
			
		mesh.setMaterial(new Material("default", new TextureAttribute(diffuseTex, 0, "skin")));
		
		animations = mesh.getAnimations();		
	}
}
