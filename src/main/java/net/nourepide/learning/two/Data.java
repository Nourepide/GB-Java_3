package net.nourepide.learning.two;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
class Data<F, S> {
    private F first;
    private S second;
}