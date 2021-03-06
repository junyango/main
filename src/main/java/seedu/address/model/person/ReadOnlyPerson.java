package seedu.address.model.person;

import java.util.List;
import java.util.Set;

import javafx.beans.property.ObjectProperty;
import seedu.address.model.property.Address;
import seedu.address.model.property.Email;
import seedu.address.model.property.Name;
import seedu.address.model.property.Phone;
import seedu.address.model.property.Property;
import seedu.address.model.property.UniquePropertyMap;
import seedu.address.model.tag.Tag;
import seedu.address.model.tag.UniqueTagList;

/**
 * A read-only immutable interface for a Person in the addressBook.
 * Implementations should guarantee: details are present and not null, field values are validated.
 */
public interface ReadOnlyPerson {

    ObjectProperty<Name> nameProperty();
    Name getName();
    ObjectProperty<Phone> phoneProperty();
    Phone getPhone();
    ObjectProperty<Email> emailProperty();
    Email getEmail();
    ObjectProperty<Address> addressProperty();
    Address getAddress();
    ObjectProperty<Avatar> avatarProperty();
    Avatar getAvatar();
    void setAvatar(Avatar avatar);
    ObjectProperty<UniquePropertyMap> properties();
    Set<Property> getProperties();
    List<Property> getSortedProperties();
    ObjectProperty<UniqueTagList> tagProperty();
    Set<Tag> getTags();

    String joinTagsToString();

    /**
     * Returns true if both have the same state. (interfaces cannot override .equals)
     *
     * TODO: Should we include comparision of {@code getProperties} here?
     */
    default boolean isSameStateAs(ReadOnlyPerson other) {
        return other == this // short circuit if same object
                || (other != null // this is first to avoid NPE below
                && other.getName().equals(this.getName()) // state checks here onwards
                && other.getPhone().equals(this.getPhone())
                && other.getEmail().equals(this.getEmail())
                && other.getAddress().equals(this.getAddress()));
    }

    /**
     * Formats the person as text, showing all contact details.
     */
    default String getAsText() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getName())
                .append(" Phone: ")
                .append(getPhone())
                .append(" Email: ")
                .append(getEmail())
                .append(" Address: ")
                .append(getAddress())
                .append(" Tags: ");
        getTags().forEach(builder::append);
        return builder.toString();
    }

}
