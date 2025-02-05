package org.gradle.accessors.dm;

import org.gradle.api.NonNullApi;
import org.gradle.api.artifacts.ProjectDependency;
import org.gradle.api.internal.artifacts.dependencies.ProjectDependencyInternal;
import org.gradle.api.internal.artifacts.DefaultProjectDependencyFactory;
import org.gradle.api.internal.artifacts.dsl.dependencies.ProjectFinder;
import org.gradle.api.internal.catalog.DelegatingProjectDependency;
import org.gradle.api.internal.catalog.TypeSafeProjectDependencyFactory;
import javax.inject.Inject;

@NonNullApi
public class Logic_ApptClientProjectDependency extends DelegatingProjectDependency {

    @Inject
    public Logic_ApptClientProjectDependency(TypeSafeProjectDependencyFactory factory, ProjectDependencyInternal delegate) {
        super(factory, delegate);
    }

    /**
     * Creates a project dependency on the project at path ":logic:appt_client:api"
     */
    public Logic_ApptClient_ApiProjectDependency getApi() { return new Logic_ApptClient_ApiProjectDependency(getFactory(), create(":logic:appt_client:api")); }

    /**
     * Creates a project dependency on the project at path ":logic:appt_client:impl"
     */
    public Logic_ApptClient_ImplProjectDependency getImpl() { return new Logic_ApptClient_ImplProjectDependency(getFactory(), create(":logic:appt_client:impl")); }

}
