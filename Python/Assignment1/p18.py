

# 18.  Use parameterized or nose_parameterized to compute power of following values: 
# (2, 2, 4), 
# (2, 3, 8), 
# (1, 9, 1), 
# (0, 9, 0). Use pytest to check errors
import pytest

@pytest.mark.parametrize("base, exp, expected_result", [
    (2, 2, 4),
    (2, 3, 8),
    (1, 9, 1),
    (0, 9, 0)
])
def test_power(base, exp, expected_result):
    assert base ** exp == expected_result