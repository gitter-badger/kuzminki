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

import io.rdbc.sapi.Row


class RowConv2[R1, R2](
      shape: Tuple2[ValConv[R1], ValConv[R2]]
    ) extends RowConv[Tuple2[R1, R2]] {

  def fromRow(row: Row): Tuple2[R1, R2] = {
    shape match {
      case (col1, col2) =>
        (col1.get(row, 0), col2.get(row, 1))
    }
  }
}

class RowConv3[R1, R2, R3](
      shape: Tuple3[ValConv[R1], ValConv[R2], ValConv[R3]]
    ) extends RowConv[Tuple3[R1, R2, R3]] {

  def fromRow(row: Row): Tuple3[R1, R2, R3] = {
    shape match {
      case (col1, col2, col3) =>
        (col1.get(row, 0), col2.get(row, 1), col3.get(row, 2))
    }
  }
}

class RowConv4[R1, R2, R3, R4](
      shape: Tuple4[ValConv[R1], ValConv[R2], ValConv[R3], ValConv[R4]]
    ) extends RowConv[Tuple4[R1, R2, R3, R4]] {

  def fromRow(row: Row): Tuple4[R1, R2, R3, R4] = {
    shape match {
      case (col1, col2, col3, col4) =>
        (col1.get(row, 0), col2.get(row, 1), col3.get(row, 2), col4.get(row, 3))
    }
  }
}

class RowConv5[R1, R2, R3, R4, R5](
      shape: Tuple5[ValConv[R1], ValConv[R2], ValConv[R3], ValConv[R4], ValConv[R5]]
    ) extends RowConv[Tuple5[R1, R2, R3, R4, R5]] {

  def fromRow(row: Row): Tuple5[R1, R2, R3, R4, R5] = {
    shape match {
      case (col1, col2, col3, col4, col5) =>
        (col1.get(row, 0), col2.get(row, 1), col3.get(row, 2), col4.get(row, 3), col5.get(row, 4))
    }
  }
}

class RowConv6[R1, R2, R3, R4, R5, R6](
      shape: Tuple6[ValConv[R1], ValConv[R2], ValConv[R3], ValConv[R4], ValConv[R5], ValConv[R6]]
    ) extends RowConv[Tuple6[R1, R2, R3, R4, R5, R6]] {

  def fromRow(row: Row): Tuple6[R1, R2, R3, R4, R5, R6] = {
    shape match {
      case (col1, col2, col3, col4, col5, col6) =>
        (col1.get(row, 0), col2.get(row, 1), col3.get(row, 2), col4.get(row, 3), col5.get(row, 4), col6.get(row, 5))
    }
  }
}

class RowConv7[R1, R2, R3, R4, R5, R6, R7](
      shape: Tuple7[ValConv[R1], ValConv[R2], ValConv[R3], ValConv[R4], ValConv[R5], ValConv[R6], ValConv[R7]]
    ) extends RowConv[Tuple7[R1, R2, R3, R4, R5, R6, R7]] {

  def fromRow(row: Row): Tuple7[R1, R2, R3, R4, R5, R6, R7] = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7) =>
        (col1.get(row, 0), col2.get(row, 1), col3.get(row, 2), col4.get(row, 3), col5.get(row, 4), col6.get(row, 5), col7.get(row, 6))
    }
  }
}

class RowConv8[R1, R2, R3, R4, R5, R6, R7, R8](
      shape: Tuple8[ValConv[R1], ValConv[R2], ValConv[R3], ValConv[R4], ValConv[R5], ValConv[R6], ValConv[R7], ValConv[R8]]
    ) extends RowConv[Tuple8[R1, R2, R3, R4, R5, R6, R7, R8]] {

  def fromRow(row: Row): Tuple8[R1, R2, R3, R4, R5, R6, R7, R8] = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8) =>
        (col1.get(row, 0), col2.get(row, 1), col3.get(row, 2), col4.get(row, 3), col5.get(row, 4), col6.get(row, 5), col7.get(row, 6), col8.get(row, 7))
    }
  }
}

class RowConv9[R1, R2, R3, R4, R5, R6, R7, R8, R9](
      shape: Tuple9[ValConv[R1], ValConv[R2], ValConv[R3], ValConv[R4], ValConv[R5], ValConv[R6], ValConv[R7], ValConv[R8], ValConv[R9]]
    ) extends RowConv[Tuple9[R1, R2, R3, R4, R5, R6, R7, R8, R9]] {

  def fromRow(row: Row): Tuple9[R1, R2, R3, R4, R5, R6, R7, R8, R9] = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9) =>
        (col1.get(row, 0), col2.get(row, 1), col3.get(row, 2), col4.get(row, 3), col5.get(row, 4), col6.get(row, 5), col7.get(row, 6), col8.get(row, 7), col9.get(row, 8))
    }
  }
}

class RowConv10[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10](
      shape: Tuple10[ValConv[R1], ValConv[R2], ValConv[R3], ValConv[R4], ValConv[R5], ValConv[R6], ValConv[R7], ValConv[R8], ValConv[R9], ValConv[R10]]
    ) extends RowConv[Tuple10[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10]] {

  def fromRow(row: Row): Tuple10[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10] = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10) =>
        (col1.get(row, 0), col2.get(row, 1), col3.get(row, 2), col4.get(row, 3), col5.get(row, 4), col6.get(row, 5), col7.get(row, 6), col8.get(row, 7), col9.get(row, 8), col10.get(row, 9))
    }
  }
}

class RowConv11[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11](
      shape: Tuple11[ValConv[R1], ValConv[R2], ValConv[R3], ValConv[R4], ValConv[R5], ValConv[R6], ValConv[R7], ValConv[R8], ValConv[R9], ValConv[R10], ValConv[R11]]
    ) extends RowConv[Tuple11[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11]] {

  def fromRow(row: Row): Tuple11[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11] = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11) =>
        (col1.get(row, 0), col2.get(row, 1), col3.get(row, 2), col4.get(row, 3), col5.get(row, 4), col6.get(row, 5), col7.get(row, 6), col8.get(row, 7), col9.get(row, 8), col10.get(row, 9), col11.get(row, 10))
    }
  }
}

class RowConv12[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12](
      shape: Tuple12[ValConv[R1], ValConv[R2], ValConv[R3], ValConv[R4], ValConv[R5], ValConv[R6], ValConv[R7], ValConv[R8], ValConv[R9], ValConv[R10], ValConv[R11], ValConv[R12]]
    ) extends RowConv[Tuple12[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12]] {

  def fromRow(row: Row): Tuple12[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12] = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12) =>
        (col1.get(row, 0), col2.get(row, 1), col3.get(row, 2), col4.get(row, 3), col5.get(row, 4), col6.get(row, 5), col7.get(row, 6), col8.get(row, 7), col9.get(row, 8), col10.get(row, 9), col11.get(row, 10), col12.get(row, 11))
    }
  }
}

class RowConv13[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13](
      shape: Tuple13[ValConv[R1], ValConv[R2], ValConv[R3], ValConv[R4], ValConv[R5], ValConv[R6], ValConv[R7], ValConv[R8], ValConv[R9], ValConv[R10], ValConv[R11], ValConv[R12], ValConv[R13]]
    ) extends RowConv[Tuple13[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13]] {

  def fromRow(row: Row): Tuple13[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13] = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13) =>
        (col1.get(row, 0), col2.get(row, 1), col3.get(row, 2), col4.get(row, 3), col5.get(row, 4), col6.get(row, 5), col7.get(row, 6), col8.get(row, 7), col9.get(row, 8), col10.get(row, 9), col11.get(row, 10), col12.get(row, 11), col13.get(row, 12))
    }
  }
}

class RowConv14[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14](
      shape: Tuple14[ValConv[R1], ValConv[R2], ValConv[R3], ValConv[R4], ValConv[R5], ValConv[R6], ValConv[R7], ValConv[R8], ValConv[R9], ValConv[R10], ValConv[R11], ValConv[R12], ValConv[R13], ValConv[R14]]
    ) extends RowConv[Tuple14[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14]] {

  def fromRow(row: Row): Tuple14[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14] = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14) =>
        (col1.get(row, 0), col2.get(row, 1), col3.get(row, 2), col4.get(row, 3), col5.get(row, 4), col6.get(row, 5), col7.get(row, 6), col8.get(row, 7), col9.get(row, 8), col10.get(row, 9), col11.get(row, 10), col12.get(row, 11), col13.get(row, 12), col14.get(row, 13))
    }
  }
}

class RowConv15[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15](
      shape: Tuple15[ValConv[R1], ValConv[R2], ValConv[R3], ValConv[R4], ValConv[R5], ValConv[R6], ValConv[R7], ValConv[R8], ValConv[R9], ValConv[R10], ValConv[R11], ValConv[R12], ValConv[R13], ValConv[R14], ValConv[R15]]
    ) extends RowConv[Tuple15[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15]] {

  def fromRow(row: Row): Tuple15[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15] = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15) =>
        (col1.get(row, 0), col2.get(row, 1), col3.get(row, 2), col4.get(row, 3), col5.get(row, 4), col6.get(row, 5), col7.get(row, 6), col8.get(row, 7), col9.get(row, 8), col10.get(row, 9), col11.get(row, 10), col12.get(row, 11), col13.get(row, 12), col14.get(row, 13), col15.get(row, 14))
    }
  }
}

class RowConv16[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16](
      shape: Tuple16[ValConv[R1], ValConv[R2], ValConv[R3], ValConv[R4], ValConv[R5], ValConv[R6], ValConv[R7], ValConv[R8], ValConv[R9], ValConv[R10], ValConv[R11], ValConv[R12], ValConv[R13], ValConv[R14], ValConv[R15], ValConv[R16]]
    ) extends RowConv[Tuple16[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16]] {

  def fromRow(row: Row): Tuple16[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16] = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16) =>
        (col1.get(row, 0), col2.get(row, 1), col3.get(row, 2), col4.get(row, 3), col5.get(row, 4), col6.get(row, 5), col7.get(row, 6), col8.get(row, 7), col9.get(row, 8), col10.get(row, 9), col11.get(row, 10), col12.get(row, 11), col13.get(row, 12), col14.get(row, 13), col15.get(row, 14), col16.get(row, 15))
    }
  }
}

class RowConv17[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17](
      shape: Tuple17[ValConv[R1], ValConv[R2], ValConv[R3], ValConv[R4], ValConv[R5], ValConv[R6], ValConv[R7], ValConv[R8], ValConv[R9], ValConv[R10], ValConv[R11], ValConv[R12], ValConv[R13], ValConv[R14], ValConv[R15], ValConv[R16], ValConv[R17]]
    ) extends RowConv[Tuple17[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17]] {

  def fromRow(row: Row): Tuple17[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17] = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17) =>
        (col1.get(row, 0), col2.get(row, 1), col3.get(row, 2), col4.get(row, 3), col5.get(row, 4), col6.get(row, 5), col7.get(row, 6), col8.get(row, 7), col9.get(row, 8), col10.get(row, 9), col11.get(row, 10), col12.get(row, 11), col13.get(row, 12), col14.get(row, 13), col15.get(row, 14), col16.get(row, 15), col17.get(row, 16))
    }
  }
}

class RowConv18[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18](
      shape: Tuple18[ValConv[R1], ValConv[R2], ValConv[R3], ValConv[R4], ValConv[R5], ValConv[R6], ValConv[R7], ValConv[R8], ValConv[R9], ValConv[R10], ValConv[R11], ValConv[R12], ValConv[R13], ValConv[R14], ValConv[R15], ValConv[R16], ValConv[R17], ValConv[R18]]
    ) extends RowConv[Tuple18[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18]] {

  def fromRow(row: Row): Tuple18[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18] = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18) =>
        (col1.get(row, 0), col2.get(row, 1), col3.get(row, 2), col4.get(row, 3), col5.get(row, 4), col6.get(row, 5), col7.get(row, 6), col8.get(row, 7), col9.get(row, 8), col10.get(row, 9), col11.get(row, 10), col12.get(row, 11), col13.get(row, 12), col14.get(row, 13), col15.get(row, 14), col16.get(row, 15), col17.get(row, 16), col18.get(row, 17))
    }
  }
}

class RowConv19[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19](
      shape: Tuple19[ValConv[R1], ValConv[R2], ValConv[R3], ValConv[R4], ValConv[R5], ValConv[R6], ValConv[R7], ValConv[R8], ValConv[R9], ValConv[R10], ValConv[R11], ValConv[R12], ValConv[R13], ValConv[R14], ValConv[R15], ValConv[R16], ValConv[R17], ValConv[R18], ValConv[R19]]
    ) extends RowConv[Tuple19[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19]] {

  def fromRow(row: Row): Tuple19[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19] = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19) =>
        (col1.get(row, 0), col2.get(row, 1), col3.get(row, 2), col4.get(row, 3), col5.get(row, 4), col6.get(row, 5), col7.get(row, 6), col8.get(row, 7), col9.get(row, 8), col10.get(row, 9), col11.get(row, 10), col12.get(row, 11), col13.get(row, 12), col14.get(row, 13), col15.get(row, 14), col16.get(row, 15), col17.get(row, 16), col18.get(row, 17), col19.get(row, 18))
    }
  }
}

class RowConv20[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20](
      shape: Tuple20[ValConv[R1], ValConv[R2], ValConv[R3], ValConv[R4], ValConv[R5], ValConv[R6], ValConv[R7], ValConv[R8], ValConv[R9], ValConv[R10], ValConv[R11], ValConv[R12], ValConv[R13], ValConv[R14], ValConv[R15], ValConv[R16], ValConv[R17], ValConv[R18], ValConv[R19], ValConv[R20]]
    ) extends RowConv[Tuple20[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20]] {

  def fromRow(row: Row): Tuple20[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20] = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19, col20) =>
        (col1.get(row, 0), col2.get(row, 1), col3.get(row, 2), col4.get(row, 3), col5.get(row, 4), col6.get(row, 5), col7.get(row, 6), col8.get(row, 7), col9.get(row, 8), col10.get(row, 9), col11.get(row, 10), col12.get(row, 11), col13.get(row, 12), col14.get(row, 13), col15.get(row, 14), col16.get(row, 15), col17.get(row, 16), col18.get(row, 17), col19.get(row, 18), col20.get(row, 19))
    }
  }
}

class RowConv21[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20, R21](
      shape: Tuple21[ValConv[R1], ValConv[R2], ValConv[R3], ValConv[R4], ValConv[R5], ValConv[R6], ValConv[R7], ValConv[R8], ValConv[R9], ValConv[R10], ValConv[R11], ValConv[R12], ValConv[R13], ValConv[R14], ValConv[R15], ValConv[R16], ValConv[R17], ValConv[R18], ValConv[R19], ValConv[R20], ValConv[R21]]
    ) extends RowConv[Tuple21[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20, R21]] {

  def fromRow(row: Row): Tuple21[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20, R21] = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19, col20, col21) =>
        (col1.get(row, 0), col2.get(row, 1), col3.get(row, 2), col4.get(row, 3), col5.get(row, 4), col6.get(row, 5), col7.get(row, 6), col8.get(row, 7), col9.get(row, 8), col10.get(row, 9), col11.get(row, 10), col12.get(row, 11), col13.get(row, 12), col14.get(row, 13), col15.get(row, 14), col16.get(row, 15), col17.get(row, 16), col18.get(row, 17), col19.get(row, 18), col20.get(row, 19), col21.get(row, 20))
    }
  }
}

class RowConv22[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20, R21, R22](
      shape: Tuple22[ValConv[R1], ValConv[R2], ValConv[R3], ValConv[R4], ValConv[R5], ValConv[R6], ValConv[R7], ValConv[R8], ValConv[R9], ValConv[R10], ValConv[R11], ValConv[R12], ValConv[R13], ValConv[R14], ValConv[R15], ValConv[R16], ValConv[R17], ValConv[R18], ValConv[R19], ValConv[R20], ValConv[R21], ValConv[R22]]
    ) extends RowConv[Tuple22[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20, R21, R22]] {

  def fromRow(row: Row): Tuple22[R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20, R21, R22] = {
    shape match {
      case (col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19, col20, col21, col22) =>
        (col1.get(row, 0), col2.get(row, 1), col3.get(row, 2), col4.get(row, 3), col5.get(row, 4), col6.get(row, 5), col7.get(row, 6), col8.get(row, 7), col9.get(row, 8), col10.get(row, 9), col11.get(row, 10), col12.get(row, 11), col13.get(row, 12), col14.get(row, 13), col15.get(row, 14), col16.get(row, 15), col17.get(row, 16), col18.get(row, 17), col19.get(row, 18), col20.get(row, 19), col21.get(row, 20), col22.get(row, 21))
    }
  }
}
