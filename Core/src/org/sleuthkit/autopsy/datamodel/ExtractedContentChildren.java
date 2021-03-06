/*
 * Autopsy Forensic Browser
 * 
 * Copyright 2011 Basis Technology Corp.
 * Contact: carrier <at> sleuthkit <dot> org
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
package org.sleuthkit.autopsy.datamodel;

import java.util.Arrays;
import java.util.List;
import org.openide.nodes.ChildFactory;
import org.openide.nodes.Node;
import org.sleuthkit.datamodel.BlackboardArtifact;
import org.sleuthkit.datamodel.SleuthkitCase;

/**
 *
 */
public class ExtractedContentChildren extends ChildFactory<BlackboardArtifact.ARTIFACT_TYPE> {
    
    private SleuthkitCase skCase;

    public ExtractedContentChildren(SleuthkitCase skCase) {
        super();
        this.skCase = skCase;
    }

    @Override
    protected boolean createKeys(List<BlackboardArtifact.ARTIFACT_TYPE> list) {
        list.add(BlackboardArtifact.ARTIFACT_TYPE.TSK_WEB_BOOKMARK);
        list.add(BlackboardArtifact.ARTIFACT_TYPE.TSK_WEB_COOKIE);
        list.add(BlackboardArtifact.ARTIFACT_TYPE.TSK_WEB_HISTORY);
        list.add(BlackboardArtifact.ARTIFACT_TYPE.TSK_WEB_DOWNLOAD);
        list.add(BlackboardArtifact.ARTIFACT_TYPE.TSK_RECENT_OBJECT);
        list.add(BlackboardArtifact.ARTIFACT_TYPE.TSK_INSTALLED_PROG);
        list.add(BlackboardArtifact.ARTIFACT_TYPE.TSK_DEVICE_ATTACHED);
        list.add(BlackboardArtifact.ARTIFACT_TYPE.TSK_WEB_SEARCH_QUERY);
        list.add(BlackboardArtifact.ARTIFACT_TYPE.TSK_METADATA_EXIF);
        return true;
    }

  
    
    
    @Override
    protected Node createNodeForKey(BlackboardArtifact.ARTIFACT_TYPE key){
        return new ArtifactTypeNode(key, skCase);
    }
    
}
