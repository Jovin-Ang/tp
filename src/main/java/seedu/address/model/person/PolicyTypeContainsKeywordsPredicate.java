package seedu.address.model.person;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;

import seedu.address.commons.util.ToStringBuilder;

/**
 * Tests that a {@code Person}'s {@code Policy} type matches any of the keywords given.
 */
public class PolicyTypeContainsKeywordsPredicate implements Predicate<Person> {
    private final Set<PolicyType> keywords;

    /**
     * Constructs a {@code PolicyTypeContainsKeywordsPredicate}.
     * @param keywords A set of strings to match against policy types
     */
    public PolicyTypeContainsKeywordsPredicate(Set<PolicyType> keywords) {
        this.keywords = keywords;
    }

    /**
     * Returns an unmodifiable set of policy type keywords, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     * Returns {@code Optional#empty()} if {@code keywords} is null.
     */
    public Optional<Set<PolicyType>> getPolicyTypes() {
        return (keywords != null) ? Optional.of(Collections.unmodifiableSet(keywords)) : Optional.empty();
    }

    @Override
    public boolean test(Person person) {
        PolicyType personPolicyType = person.getPolicy().getType();
        return keywords.contains(personPolicyType);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof PolicyTypeContainsKeywordsPredicate)) {
            return false;
        }

        PolicyTypeContainsKeywordsPredicate otherPolicyTypeContainsKeywordsPredicate =
                (PolicyTypeContainsKeywordsPredicate) other;
        return keywords.equals(otherPolicyTypeContainsKeywordsPredicate.keywords);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).add("keywords", keywords).toString();
    }
}
