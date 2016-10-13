package com.Yamate.Camera.filter;

import android.opengl.GLES20;

import com.Yamate.Camera.Shader;
import com.Yamate.Camera.Util;

/**
 * Created by vincent on 08/10/2016.
 */

public class Emboss extends Filter {
    public Emboss(int w, int h) {
        super(w, h);
    }
    void init()
    {
        mFramgment_glsl="emboss_fragment_shader.glsl";
        mVertext_glsl="texture_vertext_notr_shader_3x3.glsl";
        filter_shader=new Shader();
        filter_shader.setVF(true);
        filter_shader.init(mVertext_glsl,mFramgment_glsl);
        filter_shader.init_commitResource();
        mGLProgram=filter_shader.getGLProgram();
        Util.setShaderVariableF(mGLProgram, "u_tintR", 0.0f);
        Util.setShaderVariableF(mGLProgram, "u_tintG", 0.0f);
        Util.setShaderVariableF(mGLProgram, "u_tintB", 0.3f);
        GLES20.glActiveTexture(GLES20.GL_TEXTURE1);
    }
    @Override
    public void onInit() {

        init();
    }

    @Override
    public void onSelected() {
        // TODO Auto-generated method stub

    }
}
