def triple_to_list(start, stop, step):
    result = []
    current = start
    while current < stop:
        result.append(current)
        current += step
    return result

class RLE:
    def __init__(self, sequence):
        self.sequence = sequence

    def print_seq(self):
        print(self.sequence)

    def length(self):
        sum = 0
        for pair in self.sequence:
            sum += pair[0]
        return sum

    def get_element(self, n):
        if n >= 0 and n > self.length():
            raise IndexError('list index out of range')
        else:
            for (m,c) in self.sequence:
                if n < m:
                    return c
                else:
                    n = n - m

    def slice_to_triple(self, s):
        seq_length = self.length()
        step = s.step if s.step is not None else 1
        if s.start is None:
            start = 0
        elif s.start < 0:
            start = s.start + seq_length
        else:
            start = s.start
        if s.stop is None:
            stop = seq_length
        elif s.stop < 0:
            stop = s.stop + seq_length
        else:
            stop = s.stop
        return (start, stop, step)

    def get_slice(self, s):
        start, stop, step = self.slice_to_triple(s)
        tuple = triple_to_list(start, stop, step)
        if not tuple:
            return []
        chars = []
        for i in tuple:
            chars.append(self.get_element(i))
        new_sequence = []
        current_char = chars[0]
        count = 1
        for i in chars[1:]:
            if i == current_char:
                count += 1
            else:
                new_sequence.append((count, current_char))
                current_char = i
                count = 1
        new_sequence.append((count, current_char))
        return RLE(new_sequence)


    def __getitem__(self, index):
        if isinstance(index, int):
            return self.get_element(index)
        elif isinstance(index, slice):
            return self.get_slice(index)
        
if __name__ == '__main__':
    rle = RLE([(3,'a'), (6,'b'), (2,'c'), (7,'d')])
    rle[:].print_seq()
    rle[::].print_seq()
    rle[1:9].print_seq()
    rle[1:9:2].print_seq()
    rle[1:-1:3].print_seq()
    rle[-8:-1].print_seq()