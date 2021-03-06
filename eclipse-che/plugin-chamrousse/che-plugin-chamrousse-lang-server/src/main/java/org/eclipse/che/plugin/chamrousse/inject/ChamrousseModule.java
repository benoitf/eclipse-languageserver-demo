/*******************************************************************************
 * Copyright (c) 2012-2017 Codenvy, S.A.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Codenvy, S.A. - initial API and implementation
 *******************************************************************************/
package org.eclipse.che.plugin.chamrousse.inject;

import static java.util.Arrays.asList;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;
import org.eclipse.che.api.languageserver.launcher.LanguageServerLauncher;
import org.eclipse.che.api.languageserver.shared.model.LanguageDescription;
import org.eclipse.che.inject.DynaModule;
import org.eclipse.che.plugin.chamrousse.languageserver.ChamrousseLanguageServerLauncher;

/**
 * @author Florent Benoit
 */
@DynaModule
public class ChamrousseModule extends AbstractModule {

    public static final String   LANGUAGE_ID = "chamrousse";
    private static final String[] EXTENSIONS  = new String[] {"tls", "gnb", "ski"};
    private static final String MIME_TYPE  = "text/x-chamroussse";


    @Override
    protected void configure() {

        Multibinder.newSetBinder(binder(), LanguageServerLauncher.class).addBinding().to(ChamrousseLanguageServerLauncher.class);


        LanguageDescription description = new LanguageDescription();
        description.setFileExtensions(asList(EXTENSIONS));
        description.setLanguageId(LANGUAGE_ID);
        description.setMimeType(MIME_TYPE);
        Multibinder.newSetBinder(binder(), LanguageDescription.class)
            .addBinding()
            .toInstance(description);

    }
}
