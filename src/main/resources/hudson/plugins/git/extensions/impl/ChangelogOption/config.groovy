package hudson.plugins.git.extensions.impl.ChangelogOption;

def f = namespace(lib.FormTagLib);

f.entry(title:_("Include merge commits in changelog"), field:"includeMergeCommits") {
    f.checkbox()
}

f.entry(title:_("Width to wrap commit message lines at"), field:"messageLineWrappingWidth") {
    f.number(default:76)
}
