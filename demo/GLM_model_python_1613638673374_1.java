/*
  Licensed under the Apache License, Version 2.0
    http://www.apache.org/licenses/LICENSE-2.0.html

  AUTOGENERATED BY H2O at 2021-02-18T03:58:15.513-05:00
  3.32.0.3
  
  Standalone prediction code with sample test data for GLMModel named GLM_model_python_1613638673374_1

  How to download, compile and execute:
      mkdir tmpdir
      cd tmpdir
      curl http://127.0.0.1:54321/3/h2o-genmodel.jar > h2o-genmodel.jar
      curl http://127.0.0.1:54321/3/Models.java/GLM_model_python_1613638673374_1 > GLM_model_python_1613638673374_1.java
      javac -cp h2o-genmodel.jar -J-Xmx2g -J-XX:MaxPermSize=128m GLM_model_python_1613638673374_1.java

     (Note:  Try java argument -XX:+PrintCompilation to show runtime JIT compiler behavior.)
*/
import java.util.Map;
import hex.genmodel.GenModel;
import hex.genmodel.annotations.ModelPojo;

@ModelPojo(name="GLM_model_python_1613638673374_1", algorithm="glm")
public class GLM_model_python_1613638673374_1 extends GenModel {
  public hex.ModelCategory getModelCategory() { return hex.ModelCategory.Binomial; }

  public boolean isSupervised() { return true; }
  public int nfeatures() { return 4; }
  public int nclasses() { return 2; }

  // Names of columns used by model.
  public static final String[] NAMES = NamesHolder_GLM_model_python_1613638673374_1.VALUES;
  // Number of output classes included in training data response column.
  public static final int NCLASSES = 2;

  // Column domains. The last array contains domain of response column.
  public static final String[][] DOMAINS = new String[][] {
    /* RACE */ GLM_model_python_1613638673374_1_ColInfo_0.VALUES,
    /* AGE */ null,
    /* PSA */ null,
    /* GLEASON */ null,
    /* CAPSULE */ GLM_model_python_1613638673374_1_ColInfo_4.VALUES
  };
  // Prior class distribution
  public static final double[] PRIOR_CLASS_DISTRIB = null;
  // Class distribution used for model building
  public static final double[] MODEL_CLASS_DISTRIB = null;

  public GLM_model_python_1613638673374_1() { super(NAMES,DOMAINS,"CAPSULE"); }
  public String getUUID() { return Long.toString(-6420854130430795480L); }

  // Pass in data in a double[], pre-aligned to the Model's requirements.
  // Jam predictions into the preds[] array; preds[0] is reserved for the
  // main prediction (class for classifiers or value for regression),
  // and remaining columns hold a probability distribution for classifiers.
  public final double[] score0( double[] data, double[] preds ) {
    final double [] b = BETA.VALUES;
    for(int i = 0; i < 1; ++i) if(Double.isNaN(data[i])) data[i] = CAT_MODES.VALUES[i];
    for(int i = 0; i < 3; ++i) if(Double.isNaN(data[i + 1])) data[i+1] = NUM_MEANS.VALUES[i];
    double eta = 0.0;
    for(int i = 0; i < CATOFFS.length-1; ++i) {
      int ival = (int)data[i];
      if(ival != data[i]) throw new IllegalArgumentException("categorical value out of range");
      ival += CATOFFS[i];
      if(ival < CATOFFS[i + 1])
        eta += b[ival];
    }
    for(int i = 1; i < b.length-1-1; ++i)
    eta += b[1+i]*data[i];
    eta += b[b.length-1]; // reduce intercept
    double mu = hex.genmodel.GenModel.GLM_logitInv(eta);
    preds[0] = (mu >= 0.3013814467120079) ? 1 : 0; // threshold given by ROC
    preds[1] = 1.0 - mu; // class 0
    preds[2] =       mu; // class 1
    return preds;
  }
    public static class BETA implements java.io.Serializable {
      public static final double[] VALUES = new double[6];
      static {
        BETA_0.fill(VALUES);
      }
      static final class BETA_0 implements java.io.Serializable {
        static final void fill(double[] sa) {
          sa[0] = 0.2502528707088587;
          sa[1] = -0.24203900661628655;
          sa[2] = -0.021574877311133958;
          sa[3] = 0.02823624475366092;
          sa[4] = 1.072934769711424;
          sa[5] = -6.531154239276896;
        }
      }
}
// Imputed numeric values
    static class NUM_MEANS implements java.io.Serializable {
      public static final double[] VALUES = new double[3];
      static {
        NUM_MEANS_0.fill(VALUES);
      }
      static final class NUM_MEANS_0 implements java.io.Serializable {
        static final void fill(double[] sa) {
          sa[0] = 66.03947368421103;
          sa[1] = 15.408631578947343;
          sa[2] = 6.384210526315727;
        }
      }
}
// Imputed categorical values.
    static class CAT_MODES implements java.io.Serializable {
      public static final int[] VALUES = new int[1];
      static {
        CAT_MODES_0.fill(VALUES);
      }
      static final class CAT_MODES_0 implements java.io.Serializable {
        static final void fill(int[] sa) {
          sa[0] = 0;
        }
      }
}
    // Categorical Offsets
    public static final int[] CATOFFS = {0,2};
}
// The class representing training column names
class NamesHolder_GLM_model_python_1613638673374_1 implements java.io.Serializable {
  public static final String[] VALUES = new String[4];
  static {
    NamesHolder_GLM_model_python_1613638673374_1_0.fill(VALUES);
  }
  static final class NamesHolder_GLM_model_python_1613638673374_1_0 implements java.io.Serializable {
    static final void fill(String[] sa) {
      sa[0] = "RACE";
      sa[1] = "AGE";
      sa[2] = "PSA";
      sa[3] = "GLEASON";
    }
  }
}
// The class representing column RACE
class GLM_model_python_1613638673374_1_ColInfo_0 implements java.io.Serializable {
  public static final String[] VALUES = new String[2];
  static {
    GLM_model_python_1613638673374_1_ColInfo_0_0.fill(VALUES);
  }
  static final class GLM_model_python_1613638673374_1_ColInfo_0_0 implements java.io.Serializable {
    static final void fill(String[] sa) {
      sa[0] = "1";
      sa[1] = "2";
    }
  }
}
// The class representing column CAPSULE
class GLM_model_python_1613638673374_1_ColInfo_4 implements java.io.Serializable {
  public static final String[] VALUES = new String[2];
  static {
    GLM_model_python_1613638673374_1_ColInfo_4_0.fill(VALUES);
  }
  static final class GLM_model_python_1613638673374_1_ColInfo_4_0 implements java.io.Serializable {
    static final void fill(String[] sa) {
      sa[0] = "0";
      sa[1] = "1";
    }
  }
}

