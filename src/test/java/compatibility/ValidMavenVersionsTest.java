package compatibility;

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

import io.takari.maven.testing.TestResources;
import io.takari.maven.testing.executor.MavenExecutionResult;
import io.takari.maven.testing.executor.MavenRuntime;
import io.takari.maven.testing.executor.MavenVersions;
import io.takari.maven.testing.executor.junit.MavenJUnitTestRunner;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;

import static io.takari.maven.testing.TestResources.assertFilesPresent;

// http://takari.io/book/70-testing.html
@RunWith(MavenJUnitTestRunner.class)
@MavenVersions({"3.6.3"})
//@MavenVersions({"3.6.3", "3.6.2", "3.6.1", "3.6.0", "3.5.4", "3.5.3","3.5.2","3.5.0"})
public class ValidMavenVersionsTest {

    @Rule
    public final TestResources resources = new TestResources("src/test/resources/compatibility", "target/test-examples-compatibility");

    public final MavenRuntime mavenRuntime;


    public ValidMavenVersionsTest(MavenRuntime.MavenRuntimeBuilder builder) throws Exception {
        this.mavenRuntime = builder.build();
    }

    @Test
    public void buildExample() throws Exception {
        File basedir = resources.getBasedir("project-to-test");
        MavenExecutionResult result = mavenRuntime
                .forProject(basedir)
                .execute("clean", "com.github.funthomas424242:plantuml-maven-plugin:generate");

        result.assertErrorFreeLog();
        assertFilesPresent(basedir, "target/plantuml/src/main/plantuml/AblaufManuelleGenerierung.png");
    }
}
