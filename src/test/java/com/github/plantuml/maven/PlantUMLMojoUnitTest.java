package com.github.plantuml.maven;

/*-
 * #%L
 * Maven PlantUML plugin
 * %%
 * Copyright (C) 2011 - 2019 Julien Eluard
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import io.takari.maven.testing.TestMavenRuntime;
import io.takari.maven.testing.TestResources;
import org.apache.maven.model.Plugin;
import org.apache.maven.model.PluginExecution;
import org.apache.maven.project.MavenProject;
import org.junit.Rule;
import org.junit.Test;

import java.io.File;
import java.util.Map;

import static io.takari.maven.testing.TestMavenRuntime.newParameter;
import static io.takari.maven.testing.TestResources.assertFilesPresent;

public class PlantUMLMojoUnitTest {
    @Rule
    public final TestResources resources = new TestResources("src/test/resources/unit", "target/test-unit");

    @Rule
    public final TestMavenRuntime maven = new TestMavenRuntime();

    @Test
    public void basicTest() throws Exception {
        File basedir = resources.getBasedir("project-to-test");
        maven.executeMojo(basedir, "generate", newParameter("name", "value"));
        assertFilesPresent(basedir, "target/plantuml/AblaufManuelleGenerierung.png");
        assertFilesPresent(basedir, "target/plantuml/QueueStatechart.png");
    }

    @Test
    public void checkParameter() throws Exception {
        File basedir = resources.getBasedir("project-to-test");
        final MavenProject mavenProject = maven.readMavenProject(basedir);
        mavenProject.getBasedir();
        final Plugin plugin = mavenProject.getPlugin("com.github.funthomas424242:plantuml-maven-plugin");
        final Map<String, PluginExecution> executionMap = plugin.getExecutionsAsMap();
//        executionMap.get("");

    }


//        assertNotNull(mojo.outputDirectory);
//
//        /* check default values */
//        // check outputDirectory
//        final Path plantumlTargetDir = Paths.get("target/plantuml");
//        assertEquals(plantumlTargetDir.toAbsolutePath().toFile(), mojo.outputDirectory);
//        // outputInSourceDirectory
//        assertFalse(mojo.outputInSourceDirectory);
//        // verbose
//        assertFalse(mojo.verbose);
//
//        /* check required parameters */
//        assertNotNull(mojo.sourceFiles);
//        assertEquals(Paths.get("").toAbsolutePath().toString(), mojo.sourceFiles.getDirectory().toString());
//
//        /* check others parameters */
//        assertNotNull(mojo.truncatePattern);
//        assertEquals("src/main/*", mojo.truncatePattern);
//    }
}
