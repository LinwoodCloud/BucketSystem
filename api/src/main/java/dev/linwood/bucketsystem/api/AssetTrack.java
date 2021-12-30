package dev.linwood.bucketsystem.api;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class AssetTrack {
    private final BucketAsset parent;
    private String name, slug, description = "";
    private final Set<TrackEntry> entries = new HashSet<>();

    public AssetTrack(BucketAsset parent, String slug) {
        this.parent = parent;
        this.slug = slug;
        name = slug;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BucketAsset getParent() {
        return parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<TrackEntry> getEntries() {
        return Collections.unmodifiableSet(entries);
    }

    public TrackEntry registerEntry(String slug, String link) {
        var entry = new TrackEntry(this, slug, link);
        if (!entries.add(entry))
            return null;
        return entry;
    }

}
