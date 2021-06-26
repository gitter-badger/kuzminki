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


import java.time._
import io.rdbc.sapi.DecimalNumber


trait StringFunctionSingle extends SingleColFunction with StringCol

trait NumericFunctionSingle extends SingleColFunction with NumericCol

trait ShortFunctionSingle extends SingleColFunction with ShortCol

trait IntFunctionSingle extends SingleColFunction with IntCol

trait LongFunctionSingle extends SingleColFunction with LongCol

trait FloatFunctionSingle extends SingleColFunction with FloatCol

trait DoubleFunctionSingle extends SingleColFunction with DoubleCol

trait InstantFunctionSingle extends SingleColFunction with InstantCol