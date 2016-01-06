package hudson.plugins.git.extensions.impl;

import hudson.Extension;
import hudson.model.TaskListener;
import hudson.plugins.git.GitException;
import hudson.plugins.git.GitSCM;
import hudson.plugins.git.extensions.GitSCMExtension;
import hudson.plugins.git.extensions.GitSCMExtensionDescriptor;
import java.io.IOException;
import org.jenkinsci.plugins.gitclient.ChangelogCommand;
import org.jenkinsci.plugins.gitclient.GitClient;
import org.kohsuke.stapler.DataBoundConstructor;


public class ChangelogOption extends GitSCMExtension {
    
    private boolean includeMergeCommits;
    private int messageLineWrappingWidth;
    
    public boolean getIncludeMergeCommits() {
        return includeMergeCommits;
    }
    
    public int getMessageLineWrappingWidth() {
        return messageLineWrappingWidth;
    }
    
    @DataBoundConstructor
    public ChangelogOption(boolean includeMergeCommits, int messageLineWrappingWidth) {
        this.includeMergeCommits = includeMergeCommits;
        this.messageLineWrappingWidth = messageLineWrappingWidth;
    }
    
    @Override
    public void decorateChangelogCommand(GitSCM scm, GitClient git, TaskListener listener, ChangelogCommand cmd) throws IOException, InterruptedException, GitException {
        if (includeMergeCommits)
            cmd.includeMergeCommits();
        cmd.messageLineWrappingWidth(messageLineWrappingWidth);
    }

    @Extension
    public static class DescriptorImpl extends GitSCMExtensionDescriptor {

        @Override
        public String getDisplayName() {
            return "Advanced changelog behaviours";
        }
    }
}
