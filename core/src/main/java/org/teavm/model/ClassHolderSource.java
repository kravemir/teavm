/*
 *  Copyright 2013 Alexey Andreev.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.teavm.model;

import java.util.stream.Stream;

public interface ClassHolderSource extends ClassReaderSource {
    @Override
    ClassHolder get(String name);

    default Stream<ClassHolder> getMutableAncestors(String name) {
        return getAncestors(name).map(cls -> (ClassHolder) cls);
    }

    default Stream<ClassHolder> getMutableAncestorClasses(String name) {
        return getAncestorClasses(name).map(cls -> (ClassHolder) cls);
    }

    default MethodHolder resolveMutable(MethodReference method) {
        return (MethodHolder) resolve(method);
    }

    default FieldHolder resolveMutable(FieldReference field) {
        return (FieldHolder) resolve(field);
    }

    default Stream<MethodHolder> mutableOverridenMethods(MethodReference method) {
        return overriddenMethods(method).map(m -> (MethodHolder) m);
    }
}