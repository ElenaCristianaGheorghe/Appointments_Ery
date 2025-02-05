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
public class BusinessLogic_AppointmentsClientProjectDependency extends DelegatingProjectDependency {

    @Inject
    public BusinessLogic_AppointmentsClientProjectDependency(TypeSafeProjectDependencyFactory factory, ProjectDependencyInternal delegate) {
        super(factory, delegate);
    }

    /**
     * Creates a project dependency on the project at path ":business_logic:appointments_client:api"
     */
    public BusinessLogic_AppointmentsClient_ApiProjectDependency getApi() { return new BusinessLogic_AppointmentsClient_ApiProjectDependency(getFactory(), create(":business_logic:appointments_client:api")); }

    /**
     * Creates a project dependency on the project at path ":business_logic:appointments_client:impl"
     */
    public BusinessLogic_AppointmentsClient_ImplProjectDependency getImpl() { return new BusinessLogic_AppointmentsClient_ImplProjectDependency(getFactory(), create(":business_logic:appointments_client:impl")); }

}
