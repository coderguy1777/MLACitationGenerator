// the mla class for making the citation
class MLA {
    // main mla class constructor.
    constructor(name, title, site, contrib_name, contrib_role, publisher, date_published, url) {
        this.name = name;
        this.title = title;
        this.site = site;
        this.contrib_name = contrib_name;
        this.contrib_role = contrib_role;
        this.publisher = publisher;
        this.date_published = date_published;
        this.url = url;
    }

    // formats the author of the source in a proper MLA format
    // for the citation.
    makeMLAname() {
        let formatted_name = String(this.name);
        let space_index = 0;
        for(let i = 0; i < formatted_name.length; i++) {
            if (formatted_name.charAt(i) === ' ') {
                space_index = i;
                break;
            }
        }
        return formatted_name.substring(space_index + 1, formatted_name.length) + ", " + formatted_name.substring(0, space_index) + ". ";
    }

    // makes an MLA formatted title.
    makeMLAtitle() {
        return "\"" + this.title + "\"" + ", ";
    }

    // italicizes the site title.
    makeMLAsiteTitle() {
        return " <i>" + this.site + "<\i> " + ", ";
    }

    // cites the contributor role for the site.
    makeMLAcontributor_cited() {
        return this.contrib_role + " by " + this.contrib_name + ", "
    }

    // formats the publisher name in MLA
    // format.
    makeMLApublisher_cited() {
        return this.publisher + ", ";
    }

    // formats the date properly in
    // MLA format.
    makeMLAdate() {
        let space1 = 0, space2 = 0, sourcedate = String(this.date_published), spaceindexs = "";
        for(let i = 0; i < sourcedate.length; i++) {
            if(sourcedate.charAt(i) === '  ') {
                spaceindexs = i + " ";
            }
        }
        space1 = parseInt(spaceindexs[0]);
        space2 = parseInt(spaceindexs[1]);
        return sourcedate.substring(space1, space2-1) + " " + sourcedate.substring(0, space1) + " " + sourcedate.substring(space2, sourcedate.length);
    }

    // formats the URL.
    makeMLAurl() {
        return this.url + ".";
    }

    // implements the linebreak in the citation for proper format
    // and adds spaces as well.
    linebreak() {
        let p1 = this.makeMLAname() + this.makeMLAtitle();
        let p1sub = "";
        let p2sub = "";
        if(p1.length > MAXCHARS) {
            for(let i = 0; i < MAXCHARS; i++) {
                p1sub += p1[i];
            }
            for(let j = MAXCHARS; j < p1.length; j++) {
                p2sub += p1[j];
            }
        }
        let spaces = "";
        for(let k = 0; k <= 5; k++) {
            spaces += '&nbsp';
        }
        p1sub = p1sub + '\n';
        p2sub = spaces + p2sub;
        return p1sub + p2sub;
    }

    // sets up the second part of the citation,
    // and combines all of the information for
    // the second part of the MLA citation.
    concact_citation_info() {
        return this.linebreak() + this.makeMLAsiteTitle() + this.makeMLAcontributor_cited() + this.makeMLApublisher_cited() + this.makeMLAdate() + this.makeMLAurl();
    }

    // generates the final mla citation
    makeCitation() {
        return this.linebreak() + this.concact_citation_info();
    }
}