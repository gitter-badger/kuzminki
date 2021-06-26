/*
* Copyright 2021 Kári Magnússon
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package kuzminki.model


class CondShape2[P1, P2](
      shape: Tuple2[CacheCond[P1], CacheCond[P2]]
    ) extends CondShape[Tuple2[P1, P2]] {

  def conds = {
    conds match {
      case (col1, col2) =>
        Seq(col1, col2)
    }
  }
}

class CondShape3[P1, P2, P3](
      shape: Tuple3[CacheCond[P1], CacheCond[P2], CacheCond[P3]]
    ) extends CondShape[Tuple3[P1, P2, P3]] {

  def conds = {
    conds match {
      case (col1, col2, col3) =>
        Seq(col1, col2, col3)
    }
  }
}

class CondShape4[P1, P2, P3, P4](
      shape: Tuple4[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4]]
    ) extends CondShape[Tuple4[P1, P2, P3, P4]] {

  def conds = {
    conds match {
      case (col1, col2, col3, col4) =>
        Seq(col1, col2, col3, col4)
    }
  }
}

class CondShape5[P1, P2, P3, P4, P5](
      shape: Tuple5[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5]]
    ) extends CondShape[Tuple5[P1, P2, P3, P4, P5]] {

  def conds = {
    conds match {
      case (col1, col2, col3, col4, col5) =>
        Seq(col1, col2, col3, col4, col5)
    }
  }
}

class CondShape6[P1, P2, P3, P4, P5, P6](
      shape: Tuple6[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6]]
    ) extends CondShape[Tuple6[P1, P2, P3, P4, P5, P6]] {

  def conds = {
    conds match {
      case (col1, col2, col3, col4, col5, col6) =>
        Seq(col1, col2, col3, col4, col5, col6)
    }
  }
}

class CondShape7[P1, P2, P3, P4, P5, P6, P7](
      shape: Tuple7[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7]]
    ) extends CondShape[Tuple7[P1, P2, P3, P4, P5, P6, P7]] {

  def conds = {
    conds match {
      case (col1, col2, col3, col4, col5, col6, col7) =>
        Seq(col1, col2, col3, col4, col5, col6, col7)
    }
  }
}

class CondShape8[P1, P2, P3, P4, P5, P6, P7, P8](
      shape: Tuple8[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8]]
    ) extends CondShape[Tuple8[P1, P2, P3, P4, P5, P6, P7, P8]] {

  def conds = {
    conds match {
      case (col1, col2, col3, col4, col5, col6, col7, col8) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8)
    }
  }
}

class CondShape9[P1, P2, P3, P4, P5, P6, P7, P8, P9](
      shape: Tuple9[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9]]
    ) extends CondShape[Tuple9[P1, P2, P3, P4, P5, P6, P7, P8, P9]] {

  def conds = {
    conds match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9)
    }
  }
}

class CondShape10[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10](
      shape: Tuple10[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10]]
    ) extends CondShape[Tuple10[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10]] {

  def conds = {
    conds match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10)
    }
  }
}

class CondShape11[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11](
      shape: Tuple11[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11]]
    ) extends CondShape[Tuple11[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11]] {

  def conds = {
    conds match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11)
    }
  }
}

class CondShape12[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12](
      shape: Tuple12[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11], CacheCond[P12]]
    ) extends CondShape[Tuple12[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12]] {

  def conds = {
    conds match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12)
    }
  }
}

class CondShape13[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13](
      shape: Tuple13[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11], CacheCond[P12], CacheCond[P13]]
    ) extends CondShape[Tuple13[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13]] {

  def conds = {
    conds match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13)
    }
  }
}

class CondShape14[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14](
      shape: Tuple14[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11], CacheCond[P12], CacheCond[P13], CacheCond[P14]]
    ) extends CondShape[Tuple14[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14]] {

  def conds = {
    conds match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14)
    }
  }
}

class CondShape15[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15](
      shape: Tuple15[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11], CacheCond[P12], CacheCond[P13], CacheCond[P14], CacheCond[P15]]
    ) extends CondShape[Tuple15[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15]] {

  def conds = {
    conds match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15)
    }
  }
}

class CondShape16[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16](
      shape: Tuple16[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11], CacheCond[P12], CacheCond[P13], CacheCond[P14], CacheCond[P15], CacheCond[P16]]
    ) extends CondShape[Tuple16[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16]] {

  def conds = {
    conds match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16)
    }
  }
}

class CondShape17[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17](
      shape: Tuple17[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11], CacheCond[P12], CacheCond[P13], CacheCond[P14], CacheCond[P15], CacheCond[P16], CacheCond[P17]]
    ) extends CondShape[Tuple17[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17]] {

  def conds = {
    conds match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17)
    }
  }
}

class CondShape18[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18](
      shape: Tuple18[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11], CacheCond[P12], CacheCond[P13], CacheCond[P14], CacheCond[P15], CacheCond[P16], CacheCond[P17], CacheCond[P18]]
    ) extends CondShape[Tuple18[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18]] {

  def conds = {
    conds match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18)
    }
  }
}

class CondShape19[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19](
      shape: Tuple19[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11], CacheCond[P12], CacheCond[P13], CacheCond[P14], CacheCond[P15], CacheCond[P16], CacheCond[P17], CacheCond[P18], CacheCond[P19]]
    ) extends CondShape[Tuple19[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19]] {

  def conds = {
    conds match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19)
    }
  }
}

class CondShape20[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, P20](
      shape: Tuple20[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11], CacheCond[P12], CacheCond[P13], CacheCond[P14], CacheCond[P15], CacheCond[P16], CacheCond[P17], CacheCond[P18], CacheCond[P19], CacheCond[P20]]
    ) extends CondShape[Tuple20[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, P20]] {

  def conds = {
    conds match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19, col20) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19, col20)
    }
  }
}

class CondShape21[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, P20, P21](
      shape: Tuple21[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11], CacheCond[P12], CacheCond[P13], CacheCond[P14], CacheCond[P15], CacheCond[P16], CacheCond[P17], CacheCond[P18], CacheCond[P19], CacheCond[P20], CacheCond[P21]]
    ) extends CondShape[Tuple21[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, P20, P21]] {

  def conds = {
    conds match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19, col20, col21) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19, col20, col21)
    }
  }
}

class CondShape22[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, P20, P21, P22](
      shape: Tuple22[CacheCond[P1], CacheCond[P2], CacheCond[P3], CacheCond[P4], CacheCond[P5], CacheCond[P6], CacheCond[P7], CacheCond[P8], CacheCond[P9], CacheCond[P10], CacheCond[P11], CacheCond[P12], CacheCond[P13], CacheCond[P14], CacheCond[P15], CacheCond[P16], CacheCond[P17], CacheCond[P18], CacheCond[P19], CacheCond[P20], CacheCond[P21], CacheCond[P22]]
    ) extends CondShape[Tuple22[P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, P20, P21, P22]] {

  def conds = {
    conds match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19, col20, col21, col22) =>
        Seq(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19, col20, col21, col22)
    }
  }
}
