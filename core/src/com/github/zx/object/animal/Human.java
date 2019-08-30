package com.github.zx.object.animal;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.github.zx.object.MultipleSpriteAbstract;
import com.github.zx.utils.AssetsNameSpace;

/**
 * @Author: zx
 * @Date: 2019/8/28 11:34
 */
public class Human extends MultipleSpriteAbstract {
    public static Texture hair = new Texture(Gdx.files.internal(AssetsNameSpace.core$assets$textures$things$pawn$human$hairs$Afro_south$png));
    public static Texture head = new Texture(Gdx.files.internal(AssetsNameSpace.core$assets$textures$things$pawn$human$apparel$Female_Narrow_Wide_south$png));
    public static Texture body = new Texture(Gdx.files.internal(AssetsNameSpace.core$assets$textures$things$pawn$human$apparel$Naked_Hulk_south$png));
    public static Texture hat = new Texture(Gdx.files.internal(AssetsNameSpace.core$assets$textures$things$pawn$human$apparel$CowboyHat_south$png));
    public static Texture coat = new Texture(Gdx.files.internal(AssetsNameSpace.core$assets$textures$things$pawn$human$apparel$TribalA_Hulk_south$png));
    private float headOffset = 30;

    public Human() {
        super();
        Sprite hairSprite = new Sprite(hair);
        hairSprite.setColor(Color.valueOf("919598"));
        Sprite headSprite = new Sprite(head);
        headSprite.setColor(Color.valueOf("fae5cb"));
        //headSprite.setCenter(0,headOffset);
        Sprite hatSprite = new Sprite(hat);
        hatSprite.setY(headOffset);
        Sprite coatSprite = new Sprite(coat);
        coatSprite.setColor(Color.valueOf("ff9d00"));
        Sprite bodySprite = new Sprite(body);
        bodySprite.setColor(Color.valueOf("fae5cb"));

        addSprite(BodyStructure.BODY.toString(),bodySprite);
        addSprite(BodyStructure.HEAD.toString(),headSprite,0,headOffset);
        //addSprite(BodyStructure.HAIR.toString(),hairSprite);
        addSprite(BodyStructure.HAT.toString(),hatSprite,0,headOffset);
        addSprite(BodyStructure.COAT.toString(),coatSprite);
    }

    enum BodyStructure {
        HAIR, HEAD ,BODY, HAT, COAT
    }
}
